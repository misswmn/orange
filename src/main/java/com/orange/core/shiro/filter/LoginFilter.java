package com.orange.core.shiro.filter;

import com.orange.core.domain.User;
import com.orange.core.shiro.token.manager.TokenManager;
import com.orange.core.util.LoggerUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmn
 * @date 2017/8/6
 */
public class LoginFilter extends AccessControlFilter {
    final static Class<LoginFilter> CLASS = LoginFilter.class;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        User user = TokenManager.getCurrentUser();
        if (user != null || isLoginRequest(request, response)) {
            return true;
        }
        if (ShiroFilterUtils.isAjax(request)) {
            Map<String, String> resultMap = new HashMap<String, String>();
            LoggerUtils.debug(getClass(), "当前用户没有登录，并且是Ajax请求！");
            resultMap.put("login_status", "300");
            resultMap.put("message", "\u5F53\u524D\u7528\u6237\u6CA1\u6709\u767B\u5F55\uFF01");
            ShiroFilterUtils.out(response, resultMap);
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //保存Request和Response 到登录后的链接
        saveRequestAndRedirectToLogin(request, response);
        return Boolean.FALSE;
    }
}
