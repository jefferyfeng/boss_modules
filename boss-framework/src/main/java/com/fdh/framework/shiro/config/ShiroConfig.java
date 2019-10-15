//package com.fdh.framework.shiro.config;
//
//import com.fdh.framework.shiro.realm.UserRealm;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.codec.Base64;
//import org.apache.shiro.mgt.RememberMeManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//@Slf4j
//public class ShiroConfig {
//    /** Session超时时间，单位为毫秒（默认30分钟） */
//    @Value("${shiro.session.expireTime:30}")
//    private int expireTime;
//
//    /** 验证码开关 */
//    @Value("${shiro.user.captchaEnabled:false}")
//    private boolean captchaEnabled;
//
//    /** 设置Cookie的域名 */
//    @Value("${shiro.cookie.domain}")
//    private String domain;
//
//    /** 设置cookie的有效访问路径 */
//    @Value("${shiro.cookie.path:/}")
//    private String path;
//
//    /** 设置HttpOnly属性 */
//    @Value("${shiro.cookie.httpOnly:true}")
//    private boolean httpOnly;
//
//    /** 设置Cookie的过期时间，天为单位 */
//    @Value("${shiro.cookie.maxAge:30}")
//    private int maxAge;
//
//    /** 登录地址 */
//    @Value("${shiro.user.loginUrl}")
//    private String loginUrl;
//
//    /** 权限认证失败地址 */
//    @Value("${shiro.user.unauthorizedUrl}")
//    private String unauthorizedUrl;
//
//    /**
//     * @description:  自定义身份认证 realm
//     * @date: 2019/7/4 13:23
//     * @author: fdh
//     * @return: com.fdh.framework.shiro.realm.UserRealm
//     */
//    @Bean
//    public UserRealm userRealm() {
//        return new UserRealm();
//    }
//
//    /**
//     * @description:  设置cookie属性
//     * @date: 2019/7/4 13:28
//     * @author: fdh
//     * @return: org.apache.shiro.web.servlet.SimpleCookie
//     */
//    @Bean
//    @ConfigurationProperties(prefix = "shiro.cookie")
//    public SimpleCookie rememberMeCookie() {
//        SimpleCookie cookie = new SimpleCookie("rememberMe");
//        cookie.setDomain(domain);
//        cookie.setPath(path);
//        cookie.setHttpOnly(httpOnly);
//        //cookie过期时间 秒为单位
//        cookie.setMaxAge(maxAge * 24 * 60 * 60);
//        return cookie;
//    }
//
//    /**
//     * @description: 记住我
//     * @date: 2019/7/4 13:27
//     * @author: fdh
//     * @return: org.apache.shiro.web.mgt.CookieRememberMeManager
//     */
//    @Bean
//    public CookieRememberMeManager rememberMeManager(SimpleCookie simpleCookie) {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(simpleCookie);
//        cookieRememberMeManager.setCipherKey(Base64.decode("fCq+/xW488hMTCD+cmJ3aQ=="));
//        return cookieRememberMeManager;
//    }
//
//    /**
//     * @description:  安全管理器
//     * @date: 2019/7/4 13:40
//     * @author: fdh
//     * @return: org.apache.shiro.mgt.SecurityManager
//     */
//    @Bean
//    public SecurityManager securityManager(UserRealm userRealm,CookieRememberMeManager cookieRememberMeManager) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        // 设置realm
//        securityManager.setRealm(userRealm);
//        // 记住我
//        securityManager.setRememberMeManager(cookieRememberMeManager);
//        return securityManager;
//    }
//
//    /**
//     * @description: Filter工厂，设置对应的过滤条件和跳转条件
//     *
//     *     /admins/**=anon               # 表示该 uri 可以匿名访问
//     *     /admins/**=auth               # 表示该 uri 需要认证才能访问
//     *     /admins/**=authcBasic         # 表示该 uri 需要 httpBasic 认证
//     *     /admins/**=perms[user:add:*]  # 表示该 uri 需要认证用户拥有 user:add:* 权限才能访问
//     *     /admins/**=port[8080]         # 表示该 uri 需要使用 8080 端口
//     *     /admins/**=roles[admin]       # 表示该 uri 需要认证用户拥有 admin 角色才能访问
//     *     /admins/**=ssl                # 表示该 uri 需要使用 https 协议
//     *     /admins/**=user               # 表示该 uri 需要认证或通过记住我认证才能访问
//     *     /logout=logout                # 表示注销,可以当作固定配置
//     *
//     *     注意：
//     *     anon，authcBasic，authc，user 是认证过滤器。
//     *     perms，roles，ssl，rest，port 是授权过滤器。
//     *
//     * @date: 2019/7/4 13:58
//     * @author: fdh
//     * @param: [securityManager]
//     * @return: org.apache.shiro.spring.web.ShiroFilterFactoryBean
//     */
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        // Shiro的核心安全接口,这个属性是必须的
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        // 身份认证地址，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
//        shiroFilterFactoryBean.setLoginUrl(loginUrl);
//        // 认证失败跳转页面
//        shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
//
//        // 设置拦截器
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        // 静态资源匿名
//        filterChainDefinitionMap.put("/static/**", "anon");
//        // 登陆接口匿名访问
//        filterChainDefinitionMap.put("/login", "anon");
//        // 验证码匿名访问
//        filterChainDefinitionMap.put("/captcha", "anon");
//
//        // 所有请求需要认证
//        filterChainDefinitionMap.put("/**", "user");
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//}
