package com.fdh.framework.shiro.token;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @description:  增加验证码属性
 * @date: 2019/7/4 14:14
 * @author: fdh
 */
@Getter
@Setter
public class CustomToken extends UsernamePasswordToken {
    private String captcha;

    public CustomToken() {
    }

    public CustomToken(String username, String password, String captcha, boolean rememberMe){
        super.setUsername(username);
        super.setPassword(password.toCharArray());
        this.setCaptcha(captcha);
        super.setRememberMe(rememberMe);
    }
}
