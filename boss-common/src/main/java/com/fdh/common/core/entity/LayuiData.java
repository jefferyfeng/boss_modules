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
public class LayuiData<T> extends DataTable {
    private Integer code;
    private String msg;
    private Long count;
    private T data;
}