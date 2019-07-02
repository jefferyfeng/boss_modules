package com.fdh.business.modules.per.entity;

import com.fdh.common.core.entity.BaseEntity;

import java.io.Serializable;

/**
 * SysUserRole  用户角色表
 *
 * @date: 2019/6/4 10:51
 * @author: fdh
 */
public class SysUserRole extends BaseEntity implements Serializable {
    /** id */
    private java.lang.Long id;
    /** 用户id */
    private java.lang.Long userId;
    /** 角色id */
    private java.lang.Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
