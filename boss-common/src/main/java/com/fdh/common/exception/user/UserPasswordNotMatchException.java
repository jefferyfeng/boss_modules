package com.fdh.common.exception.user;

/**
 * @description:  用户密码不正确或不符合规范异常类
 * @date: 2019/6/10 13:32
 * @author: fdh
 */
public class UserPasswordNotMatchException extends UserException {
    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
