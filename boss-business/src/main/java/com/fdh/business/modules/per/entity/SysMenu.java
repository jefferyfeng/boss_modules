package com.fdh.business.modules.per.entity;

import com.fdh.common.core.entity.BaseEntity;

import java.io.Serializable;

/**
 * SysMenu  菜单表
 *
 * @date: 2019/6/4 10:25
 * @author: fdh
 */
public class SysMenu extends BaseEntity implements Serializable {
    /** id */
    private java.lang.Long id;
    /** 菜单名称 */
    private java.lang.String menuName;
    /** 父级菜单id */
    private java.lang.Long parentId;
    /** 菜单地址 */
    private java.lang.String menuUrl;
    /** 权限 */
    private java.lang.String permission;
    /** 次序 */
    private java.lang.Integer sequence;
    /** 菜单图标 */
    private java.lang.String menuIcon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }
}