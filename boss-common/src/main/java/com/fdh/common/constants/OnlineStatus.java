package com.fdh.common.constants;

/**
 * @description:  用户会话 用户状态
 * @date: 2019/6/6 10:13
 * @author: fdh
 */
public enum OnlineStatus {
    /**
     * 在线
     */
    ONLINE("在线"),
    /**
     * 离线
     */
    OFFLINE("离线");

    private final String info;

    private OnlineStatus(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
