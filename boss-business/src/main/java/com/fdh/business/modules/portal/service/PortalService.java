package com.fdh.business.modules.portal.service;

import com.fdh.business.modules.sysuser.entity.SysUser;

/**
 * @description:  前置service
 * @date: 2019/6/24 14:59
 * @author: fdh
 */
public interface PortalService {
    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return user 数据库中用户
     */
    SysUser login(String username, String password, String captcha);
}
