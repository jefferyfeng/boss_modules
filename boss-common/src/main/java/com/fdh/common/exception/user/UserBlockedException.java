package com.fdh.common.exception.user;

/**
 * @description:  用户锁定异常类
 * @date: 2019/6/10 13:27
 * @author: fdh
 */
public class UserBlockedException extends UserException {
    public UserBlockedException()
    {
        super("user.blocked", null);
    }
}
