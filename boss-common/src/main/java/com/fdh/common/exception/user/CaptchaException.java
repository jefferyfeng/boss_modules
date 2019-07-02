package com.fdh.common.exception.user;

/**
 * @description:  验证码错误异常类
 * @date: 2019/6/10 13:26
 * @author: fdh
 */
public class CaptchaException extends UserException {
    public CaptchaException()
    {
        super("user.jcaptcha.error", null);
    }
}
