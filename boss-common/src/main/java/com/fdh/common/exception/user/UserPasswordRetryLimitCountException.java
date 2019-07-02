package com.fdh.common.exception.user;

/**
 * @description:  用户错误记数异常类
 * @date: 2019/6/10 13:33
 * @author: fdh
 */
public class UserPasswordRetryLimitCountException extends UserException {
    public UserPasswordRetryLimitCountException(int retryLimitCount) {
        super("user.password.retry.limit.count", new Object[] { retryLimitCount });
    }
}
