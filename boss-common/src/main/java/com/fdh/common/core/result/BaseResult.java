package com.fdh.common.core.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @description: 返回结果
 * @date: 2019/6/3 14:42
 * @author: fdh
 */
public class BaseResult<T> implements Serializable {
    private int code;
    private String msg;
    /** 数据为空时不序列化 */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T body;

    public BaseResult() {
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(int code, String msg, T body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}