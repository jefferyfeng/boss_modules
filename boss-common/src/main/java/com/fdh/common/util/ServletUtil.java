package com.fdh.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description:  Servlet工具类
 * @date: 2019/6/4 13:07
 * @author: fdh:
 */
public class ServletUtil {

    /**
     * @description:  获取web环境下 HttpServletRequest
     * @date: 2019/6/3 14:53
     * @author: fdh
     * @return: javax.servlet.http.HttpServletRequest
     */
    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * @description:  获取web环境下 HttpServletResponse
     * @date: 2019/6/3 14:55
     * @author: fdh
     * @return: javax.servlet.http.HttpServletResponse
     */
    public static HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * @description:  获取web环境下 HttpSession
     * @date: 2019/6/3 14:54
     * @author: fdh
     * @return: javax.servlet.http.HttpSession
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    /**
     * @description:  是否是Ajax异步请求
     * @date: 2019/6/4 13:10
     * @author: fdh
     * @param: [request]
     * @return: boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1) {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1) {
            return true;
        }

        String uri = request.getRequestURI();
        if (StringUtil.inStringIgnoreCase(uri, ".json", ".xml")) {
            return true;
        }

        String ajax = request.getParameter("__ajax");
        if (StringUtil.inStringIgnoreCase(ajax, "json", "xml")) {
            return true;
        }
        return false;
    }
}
