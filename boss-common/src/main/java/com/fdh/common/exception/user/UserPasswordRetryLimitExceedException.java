package com.fdh.common.exception.user;

/**
 * @description:  用户错误最大次数异常类
 * @date: 2019/6/10 13:33
 * @author: fdh
 */
public class UserPasswordRetryLimitExceedException extends UserException {
    public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[] { retryLimitCount });
    }
}
