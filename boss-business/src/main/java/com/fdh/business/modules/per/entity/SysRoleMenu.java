package com.fdh.business.modules.per.entity;

import com.fdh.common.core.entity.BaseEntity;

import java.io.Serializable;

/**
 * SysRoleMenu  角色菜单表
 *
 * @date: 2019/6/4 10:51
 * @author fdh
 */
public class SysRoleMenu extends BaseEntity implements Serializable {
    /** id */
    private Long id;
    /** 角色id */
    private String roleId;
    /** 菜单id */
    private String menuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

}