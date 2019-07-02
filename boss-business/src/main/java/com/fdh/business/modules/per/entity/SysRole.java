package com.fdh.business.modules.per.entity;

import com.fdh.common.core.entity.BaseEntity;

import java.io.Serializable;

/**
 * SysRole  角色表
 *
 * @date: 2019/6/4 10:24
 * @author: fdh
 */
public class SysRole extends BaseEntity implements Serializable {
    /** id */
    private java.lang.Long id;
    /** 角色名称 */
    private java.lang.String roleName;
    /** 角色描述 */
    private java.lang.String description;
    /** 状态 */
    private java.lang.Integer status;

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getRoleName() {
        return roleName;
    }

    public void setRoleName(java.lang.String roleName) {
        this.roleName = roleName;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.Integer getStatus() {
        return status;
    }

    public void setStatus(java.lang.Integer status) {
        this.status = status;
    }

}