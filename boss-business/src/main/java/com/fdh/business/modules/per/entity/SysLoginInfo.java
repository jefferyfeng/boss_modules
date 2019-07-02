package com.fdh.business.modules.per.entity;

import com.fdh.common.core.entity.BaseEntity;

/**
 *  SysLoginInfo  系统访问记录
 *
 *  @author fdh
 */
public class SysLoginInfo extends BaseEntity {
    /**主键id*/
    private Long id;
    /**用户id*/
    private String username;
    /**登录IP地址*/
    private String ipAddr;
    /**登录地点*/
    private String loginLocation;
    /**浏览器类型*/
    private String browser;
    /**操作系统*/
    private String os;
    /**登录状态（0失败 1成功）*/
    private Integer status;
    /**提示消息*/
    private String msg;

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

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}