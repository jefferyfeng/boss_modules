package com.fdh.common.core.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description: 返回结果
 * @date: 2019/6/3 14:42
 * @author: fdh
 */
@Getter
@Setter
@AllArgsConstructor
public class BaseResult<T> implements Serializable {
    private int code;
    private String msg;
    /** 数据为空时不序列化 */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T body;
}