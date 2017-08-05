package com.orange.core.shiro.token.manager;

import com.orange.core.domain.User;
import com.orange.core.shiro.token.ShiroToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @author wangmn
 * @date 2017/8/4
 */
public class TokenManager {

    public static User login(User user, Boolean rememberMe) {
        ShiroToken token = new ShiroToken(user.getUsername(), user.getPassword(), rememberMe);
        SecurityUtils.getSubject().login(token);
        return getCurrentUser();
    }

    /**
     * 获取当前登录的用户对象
     */
    public static User getCurrentUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static Long getUserId() {
        return getCurrentUser() == null ? null : getCurrentUser().getId();
    }
}
