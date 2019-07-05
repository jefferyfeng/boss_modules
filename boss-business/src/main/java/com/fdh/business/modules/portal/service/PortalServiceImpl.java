package com.fdh.business.modules.portal.service;

import com.fdh.business.modules.sysuser.dao.SysUserDao;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.constants.Constants;
import com.fdh.common.util.ServletUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:  前置service实现
 * @date: 2019/6/24 14:59
 * @author: fdh
 */
@Service
public class PortalServiceImpl implements PortalService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser login(String username, String password, String captcha) {
        String captchaSession = (String) ServletUtil.getSession().getAttribute(Constants.CAPTCHA_CODE);
        if(!captcha.equals(captchaSession)){
            throw new RuntimeException("验证码不正确");
        }

        SysUser sysUser = sysUserDao.queryByUsername(username);
        if( null == sysUser ){
            throw new RuntimeException("用户名不存在");
        }

        String salt = sysUser.getSalt();
        String md5Pwd = DigestUtils.md5Hex(password + salt);
        if(!sysUser.getPassword().equals(md5Pwd)){
            throw new RuntimeException("密码不正确");
        }

        return sysUser;
    }
}
