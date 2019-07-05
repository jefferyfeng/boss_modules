package com.fdh.common.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * layui导航栏model
 */
@Getter
@Setter
public class LayuiNav {
    /**id*/
    private java.lang.Long id;
    /**菜单名称*/
    private java.lang.String title;
    /**菜单图标*/
    private java.lang.String icon;
    /**菜单url*/
    private java.lang.String href;
    /**菜单选中*/
    private java.lang.Boolean spread;
    /**子导航菜单*/
    private List<LayuiNav> children;
}