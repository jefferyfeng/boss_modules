package com.fdh.generator.entity;

import java.util.Map;

/**
 * @description:  配置信息
 * @date: 2019/6/4 10:13
 * @author: fdh
 */
public class Configuration {
    /**项目*/
    private String projectName;
    private String dbType;
    private String dbName;
    private String dbUrl;
    private String username;
    private String password;
    private Map<String,String> mapperType;
    /** 模板版本 */
    private String templateUrl;
    /** 表名 */
    private String tableName;
}
