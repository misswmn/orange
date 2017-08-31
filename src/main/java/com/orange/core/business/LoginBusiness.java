package com.orange.core.business;

import com.orange.core.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ex-wangmengnan
 * @date 2017/8/31
 */
public interface LoginBusiness {
    /**
     * 登录
     *
     * @param request
     * @param user
     * @return url
     */
    String login(HttpServletRequest request, User user);
}