package com.fdh.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:  数据源上下文 单线程下数据源绑定切换
 * @date: 2019/6/5 11:35
 * @author: fdh
 */
public class DynamicDataSourceContextHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    /**
     * 为每个线程创建自己的线程局部变量
     */
    private static final ThreadLocal<String> CONTEXTHOLDER = new ThreadLocal<>();

    /**
     * 设置数据源变量
     * @param datasourceKey
     */
    public static void setDataSourceType(String datasourceKey){
        LOGGER.info("切换到 {} 数据源", datasourceKey);
        CONTEXTHOLDER.set(datasourceKey);
    }

    /**
     * 获取数据源变量
     * @return
     */
    public static String getDataSourceType() {
        return CONTEXTHOLDER.get();
    }

    /**
     * 清除绑定数据源
     */
    public static void clearDataSourceType(){
        CONTEXTHOLDER.remove();
    }
}
