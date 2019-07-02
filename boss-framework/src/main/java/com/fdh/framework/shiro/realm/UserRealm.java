package com.fdh.framework.shiro.realm;

import com.fdh.business.modules.per.service.PerService;
import com.fdh.business.modules.per.service.SysUserRoleService;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.constants.Constants;
import com.fdh.common.util.ServletUtil;
import com.fdh.framework.util.ShiroUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @description:  自定义Realm 认证、授权
 * @date: 2019/6/24 15:14
 * @author: fdh
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private PerService perService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * @description:  授权
     * @date: 2019/6/24 15:15
     * @author: fdh
     * @param: [principals]
     * @return: org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = ShiroUtil.getSysUser();
        // 角色 TODO

        // 菜单 TODO

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 顶级管理员拥有一切权限
        if( Constants.IS_ADMIN.YES.equals(sysUser.getIsAdmin()) ){
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        }else{ //其他用户按照配置设置权限
            Set<String> strings = sysUserRoleService.listRolesByUserId(sysUser.getId());
            //TODO
        }
        return null;
    }

    /**
     * @description:  认证
     * @date: 2019/6/24 15:15
     * @author: fdh
     * @param: [token]
     * @return: org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());

        try {
            String captcha = (String) ServletUtil.getRequest().getAttribute("captcha");
            SysUser user = perService.login(username, password, captcha);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
            return info;
        } catch (Exception e) {
            LOGGER.info("对用户[" + username + "]进行登录验证..验证未通过", e);
            throw new AuthenticationException(e.getMessage(), e);
        }
    }
}
