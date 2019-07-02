package com.fdh.business.modules.per.exception;

/**
 * @description:  用户信息相关异常
 * @date: 2019/6/4 18:11
 * @author: fdh
 */
public class UserException extends RuntimeException {
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }
}