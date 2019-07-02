package com.fdh.business.modules.per.entity;

import com.fdh.common.core.entity.BaseEntity;

/**
 *  SysUserOnline  在线用户记录
 *
 *  @author fdh
 */
public class SysUserOnline extends BaseEntity{
    /**主键id*/
    private Long id;
    /**用户会话id*/
    private String sessionId;
    /**登录账号*/
    private Long userId;
    /**登录IP地址*/
    private String ipAddr;
    /**登录地点*/
    private String loginLocation;
    /**浏览器类型*/
    private String browser;
    /**操作系统*/
    private String os;
    /**在线状态online在线offline离线*/
    private String status;
    /**session创建时间*/
    private java.util.Date startTime;
    /**session最后访问时间*/
    private java.util.Date lastAccessTime;
    /**超时时间，单位为分钟*/
    private Long expireTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.util.Date getStartTime() {
        return startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.util.Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(java.util.Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

}