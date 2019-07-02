package com.fdh.business.modules.sysuser.entity;

import com.fdh.common.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * SysUser  用户信息表
 *
 * @date: 2019/6/3 18:09
 * @author: fdh
 */
public class SysUser extends BaseEntity implements Serializable {
    /** id */
    private Long id;
    /** 用户名 */
    private String username;
    /** 真实性名 */
    private String realName;
    /** 性别 0.未知 1.男 2.女 */
    private Integer sex;
    /** 邮箱 */
    private String email;
    /** 密码 */
    private String password;
    /** 手机号 */
    private String phone;
    /** 头像 */
    private String photo;
    /** 盐值 */
    private String salt;
    /**是否顶级管理员*/
    private Integer isAdmin;
    /** 用户状态 0.禁用 1.启用 */
    private Integer status;
    /** 最后登陆IP */
    private String loginIp;
    /** 最后登陆时间 */
    private Date loginDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
