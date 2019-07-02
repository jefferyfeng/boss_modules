package com.fdh.generator.config;

/**
 * @description:  配置文件映射
 * @date: 2019/6/3 17:47
 * @author: fdh
 */
public class Configuration {
    /** 作者（代码规范要有作者信息） */
    public static String author;

    /** 生成包路径 */
    public static String packageName;

    /** 自动去除表前缀，默认是true */
    public static String removePre;

    /** 表前缀(类名不会包含表前缀) */
    public static String tablePrefix;

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        Configuration.author = author;
    }

    public static String getPackageName() {
        return packageName;
    }

    public static void setPackageName(String packageName) {
        Configuration.packageName = packageName;
    }

    public static String getRemovePre() {
        return removePre;
    }

    public static void setRemovePre(String removePre) {
        Configuration.removePre = removePre;
    }

    public static String getTablePrefix() {
        return tablePrefix;
    }

    public static void setTablePrefix(String tablePrefix) {
        Configuration.tablePrefix = tablePrefix;
    }
}
