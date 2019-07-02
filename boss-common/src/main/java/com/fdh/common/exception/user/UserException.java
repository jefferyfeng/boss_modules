package com.fdh.common.exception.user;

import com.fdh.common.exception.base.BaseException;

/**
 * @description:  用户信息异常类
 * @date: 2019/6/10 13:31
 * @author: fdh
 */
public class UserException extends BaseException {
    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
