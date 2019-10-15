package com.fdh.generator.dao;

import com.fdh.generator.entity.GenTable;

import java.util.List;

/**
 * @description:  自动生成table Dao
 * @date: 2019/10/14 14:57
 * @author: fdh
 */
public interface GenTableDao {
    /**
     * 查询table列表
     * 
     * @param genTable table信息
     * @return table集合
     */
    List<GenTable> selectGenTableList(GenTable genTable);

    /**
     * 查询据库列表
     * 
     * @param genTable table信息
     * @return 数据库表集合
     */
    List<GenTable> selectDbTableList(GenTable genTable);

    /**
     * 查询据库列表
     * 
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    List<GenTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 查询表IDtable信息
     * 
     * @param id tableID
     * @return table信息
     */
    GenTable selectGenTableById(Long id);

    /**
     * 查询表名称table信息
     * 
     * @param tableName 表名称
     * @return table信息
     */
    GenTable selectGenTableByName(String tableName);

    /**
     * 新增table
     * 
     * @param genTable table信息
     * @return 结果
     */
    int insertGenTable(GenTable genTable);

    /**
     * 修改table
     * 
     * @param genTable table信息
     * @return 结果
     */
    int updateGenTable(GenTable genTable);

    /**
     * 批量删除table
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteGenTableByIds(Long[] ids);
}