package com.fdh.web.modules.per.controller;

import com.fdh.business.modules.per.service.PerService;
import com.fdh.common.core.controller.BaseController;
import com.fdh.common.core.result.BaseResult;
import com.fdh.common.util.CreateValidateCode;
import com.fdh.common.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:  根控制器
 * @date: 2019/6/24 13:37
 * @author: fdh
 */
@RestController
public class PerController extends BaseController {

    @Autowired
    private PerService perService;

    @GetMapping("/index")
    public ModelAndView toPortal (ModelAndView modelAndView){
        modelAndView.setViewName("modules/per/index");
        return modelAndView;
    }

    @GetMapping("/captcha")
    public void captcha (HttpServletResponse response) throws IOException {
        CreateValidateCode createValidateCode = new CreateValidateCode(80,38,4);
        String code = createValidateCode.getCode();
        createValidateCode.write(response.getOutputStream());
    }

    @GetMapping("/login")
    public ModelAndView toLogin (ModelAndView modelAndView){
        modelAndView.setViewName("modules/per/login");
        return modelAndView;
    }


    /**
     * @description: 用户登陆
     * @date: 2019/6/24 15:06
     * @author: fdh
     *
     * @param username 用户名
     * @param password 密码
     * @param rememberMe 是否记住我
     * @return: com.fdh.common.core.result.BaseResult
     */
    @PostMapping("/login")
    public BaseResult login (@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam(value = "rememberMe",defaultValue = "false") Boolean rememberMe){

        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return success();
        } catch (AuthenticationException e){
            String errMsg = StringUtil.isEmpty(e.getMessage()) ? "用户名或密码错误" : e.getMessage();
            return fail(errMsg);
        }

    }
}
