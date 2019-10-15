package com.fdh.controller.system;

import com.fdh.common.core.controller.BaseController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:  主页控制器
 * @date: 2019/6/24 13:37
 * @author: fdh
 */
@RestController
public class IndexController extends BaseController {

    /**
     * @description: 跳转到首页
     * @date: 2019/7/5 15:24
     * @author: fdh
     * @param: [modelAndView]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/index")
    public ModelAndView toIndex (ModelAndView modelAndView){
        modelAndView.setViewName("index");
        //todo
        modelAndView.addObject("username", "admin");
        return modelAndView;
    }

    /**
     * @description: 跳转到主页
     * @date: 2019/10/14 13:56
     * @author: fdh
     * @param: [modelAndView]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/main")
    public ModelAndView toMain (ModelAndView modelAndView){
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
