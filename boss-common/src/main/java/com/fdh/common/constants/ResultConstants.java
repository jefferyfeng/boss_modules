package com.fdh.common.constants;

/**
 * @description: 通用返回code码 和 msg信息
 * @date: 2019/6/3 14:45
 * @author: fdh
 */
public enum ResultConstants {
    /** 成功 */
    SUCCESS(0,"成功"),
    /** 失败 */
    FAILED(1,"失败"),
    /** 异常 */
    EXCEPTION(9,"异常");

    private int code;
    private String msg;

    ResultConstants(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}