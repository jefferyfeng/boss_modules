package com.fdh.business.modules.sysuser.entity;

import com.fdh.common.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * SysUser  用户信息表
 *
 * @date: 2019/6/3 18:09
 * @author: fdh
 */
@Getter
@Setter
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
}
