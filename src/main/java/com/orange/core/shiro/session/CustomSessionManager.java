package com.orange.core.shiro.session;

import com.orange.core.shiro.CustomShiroSessionDAO;

import javax.inject.Inject;

/**
 * @author wangmn
 * @date 2017/8/6
 */
public class CustomSessionManager {
    /**
     * session status
     */
    public static final String SESSION_STATUS = "orange-online-status";
    @Inject
    private ShiroSessionRepository jedisShiroSessionRepository;
    @Inject
    private CustomShiroSessionDAO customShiroSessionDAO;
}
