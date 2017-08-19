package com.orange.core.shiro.token;

import com.orange.core.domain.User;
import com.orange.core.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author wangmn
 * @date 2017/8/5
 */
public class SampleRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleRealm.class);
    @Autowired
    private UserService userService;

    public SampleRealm() {
        super();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        ShiroToken shiroToken = (ShiroToken) token;
        User user = userService.login(shiroToken.getUsername(), new String(shiroToken.getPassword()));
        if (user == null) {
            throw new AccountException("用户名或密码不正确");
        } else if (user.getStatus() == User.Status.DISABLED) {
            throw new DisabledAccountException("该用户已经被冻结");
        } else {
            user.setLastUpdateTime(new Date());
            userService.updateLastLoginTime(user);
        }
        return new SimpleAuthenticationInfo(user, user.getUsername(), getName());
    }
}
