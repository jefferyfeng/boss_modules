package com.fdh.common.exception.base;

import com.fdh.common.util.MessageUtils;
import com.fdh.common.util.StringUtil;

/**
 * @description:  基础异常
 * @date: 2019/6/10 13:29
 * @author: fdh
 */
public class BaseException extends RuntimeException {
    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String errMsg;

    public BaseException(String module, String code, Object[] args, String errMsg) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.errMsg = errMsg;
    }

    public BaseException(String module, String code, Object[] args) {
        this(module, code, args, null);
    }

    public BaseException(String module, String errMsg) {
        this(module, null, null, errMsg);
    }

    public BaseException(String code, Object[] args) {
        this(null, code, args, null);
    }

    public BaseException(String errMsg) {
        this(null, null, null, errMsg);
    }

    @Override
    public String getMessage()
    {
        String message = null;
        if (StringUtil.isNotEmpty(message)) {
            message = MessageUtils.message(code, args);
        }
        if (message == null) {
            message = errMsg;
        }
        return message;
    }

    public String getModule()
    {
        return module;
    }

    public String getCode()
    {
        return code;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public String getErrMsg()
    {
        return errMsg;
    }
}