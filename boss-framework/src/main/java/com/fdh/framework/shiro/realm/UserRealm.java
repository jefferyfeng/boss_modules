package com.fdh.framework.shiro.realm;

import com.fdh.business.modules.per.service.SysRoleMenuService;
import com.fdh.business.modules.per.service.SysUserRoleService;
import com.fdh.business.modules.portal.service.PortalService;
import com.fdh.business.modules.sysuser.entity.SysUser;
import com.fdh.common.constants.Constants;
import com.fdh.framework.shiro.token.CustomToken;
import com.fdh.framework.util.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @description:  自定义Realm 认证、授权
 * @date: 2019/6/24 15:14
 * @author: fdh
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private PortalService portalService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

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

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 顶级管理员拥有一切权限
        if( Constants.IS_ADMIN.YES.equals(sysUser.getIsAdmin()) ){
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        }else{ //其他用户按照配置设置权限
            Set<String> roles = sysUserRoleService.listRolesByUserId(sysUser.getId());
            Set<String> permissions = sysRoleMenuService.listPermissionsByRoles(roles);

            // 角色加入AuthorizationInfo认证对象
            info.setRoles(roles);
            // 权限加入AuthorizationInfo认证对象
            info.setStringPermissions(permissions);
        }
        return info;
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
        CustomToken cToken = (CustomToken) token;
        String username = cToken.getUsername();
        String password = new String(cToken.getPassword());
        String captcha = cToken.getCaptcha();

        try {
            SysUser user = portalService.login(username, password, captcha);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
            return info;
        } catch (Exception e) {
            log.info("用户[" + username + "]进行登录认证..认证未通过");
            throw new AuthenticationException(e.getMessage(), e);
        }
    }

    /**
     * @description:  清理缓存权限
     * @date: 2019/7/2 17:32
     * @author: fdh
     * @param: []
     * @return: void
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
