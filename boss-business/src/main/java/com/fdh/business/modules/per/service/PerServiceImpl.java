package com.fdh.business.modules.per.service;

import com.fdh.business.modules.sysuser.dao.SysUserDao;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.constants.Constants;
import com.fdh.common.util.CollectionUtils;
import com.fdh.common.util.ServletUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description:  前置service实现
 * @date: 2019/6/24 14:59
 * @author: fdh
 */
public class PerServiceImpl implements PerService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser login(String username, String password, String captcha) {
        String captchaSession = (String) ServletUtil.getSession().getAttribute(Constants.CAPTCHA_CODE);
        if(!captcha.equals(captchaSession)){
            throw new RuntimeException("验证码不正确");
        }

        List<SysUser> sysUsers = sysUserDao.queryByUsername(username);
        if(CollectionUtils.isEmpty(sysUsers)){
            throw new RuntimeException("用户名不存在");
        }

        SysUser sysUser = sysUsers.get(0);
        String salt = sysUser.getSalt();
        String md5Pwd = DigestUtils.md5Hex(password + salt);
        if(!sysUser.getPassword().equals(md5Pwd)){
            throw new RuntimeException("密码不正确");
        }

        return sysUser;
    }
}
