package com.fdh.common.core.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:  LayuiDataVo
 * @date: 2019/5/21 13:11
 * @author: fdh
 */
@Getter
@Setter
public class LayuiData<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private T data;
}