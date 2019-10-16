package com.fdh.common.core.controller;

import com.fdh.common.constants.ResultConstants;
import com.fdh.common.core.entity.LayuiData;
import com.fdh.common.core.entity.page.PageBean;
import com.fdh.common.core.entity.page.TableDataInfo;
import com.fdh.common.core.entity.page.TableSupport;
import com.fdh.common.core.result.BaseResult;
import com.fdh.common.util.ResultUtil;
import com.fdh.common.util.StringUtils;
import com.fdh.common.util.date.DateUtils;
import com.fdh.common.util.sql.SqlUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * @description: 基础controller
 * @date: 2019/6/3 14:38
 * @author: fdh
 */
public class BaseController {

    /**
     * @description:  将前台传递过来的日期格式的字符串，自动转化为Date类型
     * @date: 2019/10/14 16:09
     * @author: fdh
     * @param: [binder]
     * @return: void
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * @description:  设置请求分页数据
     * @date: 2019/10/14 16:09
     * @author: fdh
     * @param: []
     * @return: void
     */
    protected void startPage() {
        PageBean pageBean = TableSupport.buildPageRequest();
        Integer pageNum = pageBean.getPageNum();
        Integer pageSize = pageBean.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageBean.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * layui响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected LayuiData getLayuiDataTable(List<?> list){
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(ResultConstants.SUCCESS.getCode());
        layuiData.setData(list);
        layuiData.setMsg(ResultConstants.SUCCESS.getMsg());
        layuiData.setCount(new PageInfo(list).getTotal());
        return layuiData;
    }

    /**
     * @description: 获取request
     * @date: 2019/6/3 15:34
     * @author: fdh
     * @return: javax.servlet.http.HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * @description: 获取response
     * @date: 2019/6/3 15:35
     * @author: fdh
     * @return: javax.servlet.http.HttpServletResponse
     */
    public HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getResponse();
    }

    /**
     * @description: 获取session
     * @date: 2019/6/3 15:35
     * @author: fdh
     * @return: javax.servlet.http.HttpSession
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * @description: 返回成功
     * @date: 2019/6/3 15:36
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public BaseResult success(){
        return ResultUtil.result(ResultConstants.SUCCESS);
    }

    /**
     * @description: 返回成功
     * @date: 2019/6/3 15:36
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public <T> BaseResult success(T body){
        return ResultUtil.result(ResultConstants.SUCCESS, body);
    }

    /**
     * @description: 返回失败
     * @date: 2019/6/3 15:36
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public BaseResult fail(){
        return ResultUtil.result(ResultConstants.FAILED);
    }

    /**
     * @description: 返回失败
     * @date: 2019/6/3 15:36
     * @param errMsg 错误信息
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public BaseResult fail(String errMsg){
        return ResultUtil.result(ResultConstants.FAILED.getCode(),errMsg);
    }

    /**
     * @description: 返回异常
     * @date: 2019/6/3 15:36
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public BaseResult exception(){
        return ResultUtil.result(ResultConstants.EXCEPTION);
    }
}
