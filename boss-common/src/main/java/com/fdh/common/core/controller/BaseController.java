package com.fdh.common.core.controller;

import com.fdh.common.constants.ResultConstants;
import com.fdh.common.core.result.BaseResult;
import com.fdh.common.util.ResultUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 基础controller
 * @date: 2019/6/3 14:38
 * @author: fdh
 */
public class BaseController {

    /**
     * @description: 获取request
     * @date: 2019/6/3 15:34
     * @author: fdh
     * @return: javax.servlet.http.HttpServletRequest
     */
    public HttpServletRequest getRequest() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * @description: 获取response
     * @date: 2019/6/3 15:35
     * @author: fdh
     * @return: javax.servlet.http.HttpServletResponse
     */
    public HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getResponse();
    }

    /**
     * @description: 获取session
     * @date: 2019/6/3 15:35
     * @author: fdh
     * @return: javax.servlet.http.HttpSession
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * @description: 返回成功
     * @date: 2019/6/3 15:36
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public BaseResult success(){
        return ResultUtil.result(ResultConstants.SUCCESS);
    }

    /**
     * @description: 返回成功
     * @date: 2019/6/3 15:36
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public <T> BaseResult success(T body){
        return ResultUtil.result(ResultConstants.SUCCESS, body);
    }

    /**
     * @description: 返回失败
     * @date: 2019/6/3 15:36
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public BaseResult fail(){
        return ResultUtil.result(ResultConstants.FAILED);
    }

    /**
     * @description: 返回失败
     * @date: 2019/6/3 15:36
     * @param errMsg 错误信息
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public BaseResult fail(String errMsg){
        return ResultUtil.result(ResultConstants.FAILED.getCode(),errMsg);
    }

    /**
     * @description: 返回异常
     * @date: 2019/6/3 15:36
     * @author: fdh
     * @return: com.fdh.common.core.result.BaseResult
     */
    public BaseResult exception(){
        return ResultUtil.result(ResultConstants.EXCEPTION);
    }
}
