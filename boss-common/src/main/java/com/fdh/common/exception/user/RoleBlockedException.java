package com.fdh.common.exception.user;

/**
 * @description:  角色锁定异常类
 * @date: 2019/6/10 13:27
 * @author: fdh
 */
public class RoleBlockedException extends UserException {
    public RoleBlockedException()
    {
        super("role.blocked", null);
    }
}
