package com.fdh.common.exception.user;

/**
 * @description:  用户账号已被删除
 * @date: 2019/6/10 13:28
 * @author: fdh
 */
public class UserDeleteException extends UserException {
    public UserDeleteException()
    {
        super("user.password.delete", null);
    }
}
