package com.orange.core.business;

import com.orange.core.common.Business;
import com.orange.core.common.ResponseEnum;
import com.orange.core.common.ServiceException;
import com.orange.core.domain.User;
import com.orange.core.shiro.token.manager.TokenManager;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ex-wangmengnan
 * @date 2017/8/31
 */
@Business
public class LoginBusinessImpl implements LoginBusiness {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginBusinessImpl.class);

    @Override
    public String login(HttpServletRequest request, User user) {
        try {
            TokenManager.login(user);
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            if (savedRequest != null) {
                return savedRequest.getRequestUrl();
            }
            return "main";
        } catch (DisabledAccountException e) {
            throw new ServiceException(ResponseEnum.ACCOUNT_LOCK);
        } catch (AuthenticationException e) {
            throw new ServiceException(ResponseEnum.USERNAME_PWD_ERROR);
        }
    }
}