package com.fdh.common.exception.user;

/**
 * @description:  用户不存在异常类
 * @date: 2019/6/10 13:32
 * @author: fdh
 */
public class UserNotExistsException extends UserException {
    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
