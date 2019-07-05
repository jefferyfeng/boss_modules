package com.fdh.web.modules.portal.controller;

import com.fdh.business.modules.per.service.SysMenuService;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.constants.Constants;
import com.fdh.common.core.controller.BaseController;
import com.fdh.common.core.entity.LayuiNav;
import com.fdh.common.core.result.BaseResult;
import com.fdh.common.util.CreateValidateCode;
import com.fdh.common.util.StringUtil;
import com.fdh.framework.shiro.token.CustomToken;
import com.fdh.framework.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:  主页控制器
 * @date: 2019/6/24 13:37
 * @author: fdh
 */
@RestController
public class PortalController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * @description: 跳转到首页
     * @date: 2019/7/5 15:24
     * @author: fdh
     * @param: [modelAndView]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/index")
    public ModelAndView toPortal (ModelAndView modelAndView){
        SysUser user = ShiroUtil.getSysUser();
        List<LayuiNav> topMenus = sysMenuService.listNavs(user);
        modelAndView.addObject("user", user);
        modelAndView.addObject("topMenus", topMenus);
        modelAndView.setViewName("modules/portal/index");
        return modelAndView;
    }

    /**
     * @description: 获取验证码
     * @date: 2019/7/5 15:25
     * @author: fdh
     * @param: [response, request]
     * @return: void
     */
    @GetMapping("/captcha")
    public void captcha (HttpServletResponse response, HttpServletRequest request) throws IOException {
        CreateValidateCode createValidateCode = new CreateValidateCode(100,38,4);
        String code = createValidateCode.getCode();
        request.getSession().setAttribute(Constants.CAPTCHA_CODE, code);
        createValidateCode.write(response.getOutputStream());
    }

    /**
     * @description:  跳转到登录页
     * @date: 2019/7/5 15:25
     * @author: fdh
     * @param: [modelAndView]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/login")
    public ModelAndView toLogin (ModelAndView modelAndView){
        modelAndView.setViewName("modules/portal/login");
        return modelAndView;
    }

    /**
     * @description:  跳转到主页
     * @date: 2019/7/5 15:25
     * @author: fdh
     * @param: [modelAndView]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/main")
    public ModelAndView toMain (ModelAndView modelAndView) {
        SysUser user = ShiroUtil.getSysUser();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("modules/portal/main");
        return modelAndView;
    }

    @GetMapping("/listMenus/${parentId}")
    public BaseResult listMenus(@PathVariable("parentId") Long parentId){
        SysUser user = ShiroUtil.getSysUser();

        Map<String,Object> bodyMap = new HashMap<String,Object>(1);
        List<LayuiNav> navsList = sysMenuService.listMenusNavs(user,parentId);

        bodyMap.put("navsList",navsList);
        return success();
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
                             @RequestParam("captcha") String captcha,
                             @RequestParam(value = "rememberMe",defaultValue = "false") Boolean rememberMe){

        CustomToken token = new CustomToken(username, password, captcha, rememberMe);
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
