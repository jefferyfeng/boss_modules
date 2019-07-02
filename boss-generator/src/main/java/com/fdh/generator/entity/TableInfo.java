package com.fdh.generator.entity;

import java.util.List;

/**
 * @description:  表映射实体
 * @date: 2019/6/3 16:39
 * @author: fdh
 */
public class TableInfo {
    /** 数据库表名 */
    private String tableName;
    /** 数据库表映射到程序中表名 */
    private String entityName;
    /** 数据库表映射到程序中表名（首字母小写） */
    private String entityNameLowFirstChar;
    /** 表的列字段集合 */
    private List<ColumnInfo> columnInfoList;
    /** 表的注释 */
    private String comment;

    public TableInfo() {
    }

    public TableInfo(String tableName, String entityName, String entityNameLowFirstChar, List<ColumnInfo> columnInfoList, String comment) {
        this.tableName = tableName;
        this.entityName = entityName;
        this.entityNameLowFirstChar = entityNameLowFirstChar;
        this.columnInfoList = columnInfoList;
        this.comment = comment;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityNameLowFirstChar() {
        return entityNameLowFirstChar;
    }

    public void setEntityNameLowFirstChar(String entityNameLowFirstChar) {
        this.entityNameLowFirstChar = entityNameLowFirstChar;
    }

    public List<ColumnInfo> getColumnInfoList() {
        return columnInfoList;
    }

    public void setColumnInfoList(List<ColumnInfo> columnInfoList) {
        this.columnInfoList = columnInfoList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
