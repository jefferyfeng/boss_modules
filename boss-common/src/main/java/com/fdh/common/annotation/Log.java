package com.fdh.common.annotation;

import com.fdh.common.enums.BusinessType;
import com.fdh.common.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @description:  自定义操作日志记录注解
 * @date: 2019/10/14 16:47
 * @author: fdh
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;
}