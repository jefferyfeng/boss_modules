package com.fdh.common.util;

import com.fdh.common.constants.ResultConstants;
import com.fdh.common.core.result.BaseResult;

/**
 * @description:  ResultUtil 返回通用的BaseResult
 * @date: 2019/6/3 15:28
 * @author: fdh
 */
public class ResultUtil{
    public static BaseResult result(int code, String msg){
        return new BaseResult(code,msg,null);
    }
    public static <T> BaseResult<T> result(int code,String msg,T body){
    return new BaseResult(code,msg,body);
    }
    public static BaseResult result(ResultConstants resultConstants){
    return new BaseResult(resultConstants.getCode(),resultConstants.getMsg(),null);
    }
    public static <T> BaseResult result(ResultConstants resultConstants, T body){
        return new BaseResult(resultConstants.getCode(),resultConstants.getMsg(),body);
    }
}
