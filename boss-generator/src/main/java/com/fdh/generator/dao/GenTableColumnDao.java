package com.fdh.generator.dao;

import com.fdh.generator.entity.GenTableColumn;

import java.util.List;

/**
 * @description:  自动生成column Dao
 * @date: 2019/10/14 15:00
 * @author: fdh
 */
public interface GenTableColumnDao
{
    /**
     * 根据表名称查询列信息
     * 
     * @param tableName 表名称
     * @return 列信息
     */
    List<GenTableColumn> selectDbTableColumnsByName(String tableName);
    
    /**
     * 查询table字段列表
     * 
     * @param genTableColumn table字段信息
     * @return table字段集合
     */
    List<GenTableColumn> selectGenTableColumnListByTableId(GenTableColumn genTableColumn);

    /**
     * 新增table字段
     * 
     * @param genTableColumn table字段信息
     * @return 结果
     */
    int insertGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 修改table字段
     * 
     * @param genTableColumn table字段信息
     * @return 结果
     */
    int updateGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 批量删除table字段
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteGenTableColumnByIds(Long[] ids);
}