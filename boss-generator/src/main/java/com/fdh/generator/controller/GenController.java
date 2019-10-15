package com.fdh.generator.controller;

import com.fdh.common.annotation.Log;
import com.fdh.common.core.controller.BaseController;
import com.fdh.common.core.entity.page.TableDataInfo;
import com.fdh.common.core.result.BaseResult;
import com.fdh.common.enums.BusinessType;
import com.fdh.common.util.text.Convert;
import com.fdh.generator.entity.GenTable;
import com.fdh.generator.entity.GenTableColumn;
import com.fdh.generator.service.GenTableColumnService;
import com.fdh.generator.service.GenTableService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @description:  自动生成 控制器
 * @date: 2019/10/14 15:59
 * @author: fdh
 */
@RestController
@RequestMapping("/tool/gen")
public class GenController extends BaseController {
    private String prefix = "tool/gen";

    @Autowired
    private GenTableService genTableService;

    @Autowired
    private GenTableColumnService genTableColumnService;

    /**
     * @description:  跳转到自动生成代码页
     * @date: 2019/10/14 16:06
     * @author: fdh
     * @param: [modelAndView]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    //@RequiresPermissions("tool:gen:view")
    @GetMapping
    public ModelAndView toGen(ModelAndView modelAndView) {
        modelAndView.setViewName(prefix + "/gen");
        return modelAndView;
    }

    /**
     * @description: 查询代码生成列表
     * @date: 2019/10/14 16:05
     * @author: fdh
     * @param: [genTable]
     * @return: com.fdh.common.core.entity.page.TableDataInfo
     */
    @RequiresPermissions("tool:gen:list")
    @PostMapping("/list")
    public TableDataInfo genList(GenTable genTable) {
        startPage();
        List<GenTable> list = genTableService.selectGenTableList(genTable);
        return getDataTable(list);
    }

    /**
     * @description: 查询数据库列表
     * @date: 2019/10/14 16:56
     * @author: fdh
     * @param: [genTable]
     * @return: com.fdh.common.core.entity.page.TableDataInfo
     */
    @RequiresPermissions("tool:gen:list")
    @PostMapping("/db/list")
    public TableDataInfo dataList(GenTable genTable) {
        startPage();
        List<GenTable> list = genTableService.selectDbTableList(genTable);
        return getDataTable(list);
    }

    /**
     * @description: 查询数据表字段列表
     * @date: 2019/10/14 16:57
     * @author: fdh
     * @param: [genTableColumn]
     * @return: com.fdh.common.core.entity.page.TableDataInfo
     */
    @RequiresPermissions("tool:gen:list")
    @PostMapping("/column/list")
    public TableDataInfo columnList(GenTableColumn genTableColumn) {
        TableDataInfo dataInfo = new TableDataInfo();
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(genTableColumn);
        dataInfo.setRows(list);
        dataInfo.setTotal(list.size());
        return dataInfo;
    }

    /**
     * @description: 导入表结构
     * @date: 2019/10/14 17:09
     * @author: fdh
     * @param: []
     * @return: java.lang.String
     */
    @RequiresPermissions("tool:gen:list")
    @GetMapping("/importTable")
    public ModelAndView importTable(ModelAndView modelAndView) {
        modelAndView.setViewName(prefix + "/importTable");
        return modelAndView;
    }

    /**
     * @description: 导入表结构（保存）
     * @date: 2019/10/14 17:10
     * @author: fdh
     * @param: [tables]
     * @return: com.fdh.common.core.result.BaseResult
     */
    @RequiresPermissions("tool:gen:list")
    @Log(title = "代码生成", businessType = BusinessType.IMPORT)
    @PostMapping("/importTable")
    public BaseResult importTableSave(String tables) {
        String[] tableNames = Convert.toStrArray(tables);
        // 查询表信息
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        //String operName = (String) PermissionUtils.getPrincipalProperty("loginName");
        genTableService.importGenTable(tableList, null);
        return success();
    }

    /**
     * @description: 修改代码生成业务
     * @date: 2019/10/14 17:11
     * @author: fdh
     * @param: [tableId, mmap]
     * @return: java.lang.String
     */
    @GetMapping("/edit/{tableId}")
    public ModelAndView edit(@PathVariable("tableId") Long tableId, ModelAndView modelAndView) {
        GenTable table = genTableService.selectGenTableById(tableId);
        modelAndView.setViewName(prefix + "/edit");
        modelAndView.addObject("table", table);
        return modelAndView;
    }

    /**
     * @description: 修改保存代码生成业务
     * @date: 2019/10/14 17:11
     * @author: fdh
     * @param: [genTable]
     * @return: com.fdh.common.core.result.BaseResult
     */
    @RequiresPermissions("tool:gen:edit")
    @Log(title = "代码生成", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public BaseResult editSave(@Validated GenTable genTable) {
        genTableService.validateEdit(genTable);
        genTableService.updateGenTable(genTable);
        return success();
    }

    /**
     * @description: 代码生成删除
     * @date: 2019/10/14 17:11
     * @author: fdh
     * @param: [ids]
     * @return: com.fdh.common.core.result.BaseResult
     */
    @RequiresPermissions("tool:gen:remove")
    @Log(title = "代码生成删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    public BaseResult remove(String ids) {
        genTableService.deleteGenTableByIds(ids);
        return success();
    }

    /**
     * @description: 预览代码
     * @date: 2019/10/14 17:12
     * @author: fdh
     * @param: [tableId]
     * @return: com.fdh.common.core.result.BaseResult
     */
    @RequiresPermissions("tool:gen:preview")
    @GetMapping("/preview/{tableId}")
    public BaseResult preview(@PathVariable("tableId") Long tableId) throws IOException {
        Map<String, String> dataMap = genTableService.previewCode(tableId);
        return success(dataMap);
    }

    /**
     * @description: 生成代码
     * @date: 2019/10/14 17:13
     * @author: fdh
     * @param: [response, tableName]
     * @return: void
     */
    @RequiresPermissions("tool:gen:code")
    @Log(title = "代码生成", businessType = BusinessType.GENCODE)
    @GetMapping("/genCode/{tableName}")
    public void genCode(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException {
        byte[] data = genTableService.generatorCode(tableName);
        genCode(response, data);
    }

    /**
     * @description: 批量生成代码
     * @date: 2019/10/14 17:13
     * @author: fdh
     * @param: [response, tables]
     * @return: void
     */
    @RequiresPermissions("tool:gen:code")
    @Log(title = "代码生成", businessType = BusinessType.GENCODE)
    @GetMapping("/batchGenCode")
    @ResponseBody
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException {
        String[] tableNames = Convert.toStrArray(tables);
        byte[] data = genTableService.generatorCode(tableNames);
        genCode(response, data);
    }

    /**
     * @description: 生成zip文件
     * @date: 2019/10/14 17:14
     * @author: fdh
     * @param: [response, data]
     * @return: void
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"ruoyi.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}