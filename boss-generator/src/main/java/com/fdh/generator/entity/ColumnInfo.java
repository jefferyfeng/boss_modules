package com.fdh.generator.entity;

/**
 * @description: 列映射实体
 * @date: 2019/6/3 16:37
 * @author: fdh
 */
public class ColumnInfo {
    /**数据库字段名*/
    private String field;
    /**映射到程序中属性名*/
    private String property;
    /**映射到程序中属性名（首字母小写）*/
    private String propertyUpFirstChar;
    /**数据库字段类型*/
    private String fieldType;
    /**映射到程序中属性类型*/
    private String propertyType;
    /**注释*/
    private String comment;
    /**是否是主键*/
    private boolean isPrimaryKey;

    public ColumnInfo() {
    }

    public ColumnInfo(String field, String property, String propertyUpFirstChar, String fieldType, String propertyType, String comment, boolean isPrimaryKey) {
        this.field = field;
        this.property = property;
        this.propertyUpFirstChar = propertyUpFirstChar;
        this.fieldType = fieldType;
        this.propertyType = propertyType;
        this.comment = comment;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyUpFirstChar() {
        return propertyUpFirstChar;
    }

    public void setPropertyUpFirstChar(String propertyUpFirstChar) {
        this.propertyUpFirstChar = propertyUpFirstChar;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }
}