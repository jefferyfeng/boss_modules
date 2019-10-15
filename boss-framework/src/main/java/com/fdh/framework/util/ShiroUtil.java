//package com.fdh.framework.util;
//
//import com.fdh.business.sysuser.entity.SysUser;
//import com.fdh.framework.shiro.realm.UserRealm;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.mgt.RealmSecurityManager;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.SimplePrincipalCollection;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.BeanUtils;
//
///**
// * @description:  shiro 工具类
// * @date: 2019/6/4 13:40
// * @author: fdh
// */
//public class ShiroUtil {
//
//    /**
//     * @description:  获取主体
//     * @date: 2019/6/4 13:40
//     * @author: fdh
//     * @return: org.apache.shiro.subject.Subject
//     */
//    public static Subject getSubject() {
//        return SecurityUtils.getSubject();
//    }
//
//    /**
//     * @description:  获取session
//     * @date: 2019/6/4 13:41
//     * @author: fdh
//     * @return: org.apache.shiro.session.Session
//     */
//    public static Session getSession() {
//        return SecurityUtils.getSubject().getSession();
//    }
//
//    /**
//     * @description:  注销
//     * @date: 2019/6/4 13:41
//     * @author: fdh
//     * @return: void
//     */
//    public static void logout() {
//        getSubject().logout();
//    }
//
//    /**
//     * @description:  获取用户
//     * @date: 2019/6/4 13:38
//     * @author: fdh
//     */
//    public static SysUser getSysUser() {
//        SysUser user = null;
//        Object obj = getSubject().getPrincipal();
//        if (null != obj) {
//            user = new SysUser();
//            BeanUtils.copyProperties(obj, user);
//        }
//        return user;
//    }
//
//    /**
//     * @description:  绑定用户
//     * @date: 2019/6/4 13:42
//     * @author: fdh
//     */
//    public static void setSysUser(SysUser user) {
//        Subject subject = getSubject();
//        PrincipalCollection principalCollection = subject.getPrincipals();
//        String realmName = principalCollection.getRealmNames().iterator().next();
//        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
//        // 重新加载Principal
//        subject.runAs(newPrincipalCollection);
//    }
//
//    /**
//     * @description:  清除授权信息
//     * @date: 2019/6/4 13:50
//     * @author: fdh
//     * @param: []
//     * @return: void
//     */
//    public static void clearCachedAuthorizationInfo() {
//        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
//        UserRealm realm = (UserRealm) rsm.getRealms().iterator().next();
//        realm.clearCachedAuthorizationInfo();
//    }
//
//    /**
//     * @description:  获取主体当前ip
//     * @date: 2019/6/4 13:44
//     * @author: fdh
//     */
//    public static String getIp() {
//        return getSubject().getSession().getHost();
//    }
//
//    /**
//     * @description:  获取sessionId
//     * @date: 2019/6/4 13:44
//     * @author: fdh
//     * @return: java.lang.String
//     */
//    public static String getSessionId() {
//        return String.valueOf(getSubject().getSession().getId());
//    }
//}
