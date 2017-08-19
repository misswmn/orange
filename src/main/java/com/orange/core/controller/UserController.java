package com.orange.core.controller;

import com.alibaba.druid.util.StringUtils;
import com.orange.core.common.ResultBean;
import com.orange.core.common.ServiceCode;
import com.orange.core.common.ServiceException;
import com.orange.core.domain.User;
import com.orange.core.shiro.token.manager.TokenManager;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by misswmn on 2017/4/8.
 */
@RestController(value = "/u")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private Map<String, Object> resultMap = new LinkedHashMap<>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean login(@Valid User user, BindingResult result,
                            Boolean rememberMe, HttpServletRequest request) {
        try {
            TokenManager.login(user, rememberMe);
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = null;
            if (savedRequest != null) {
                url = savedRequest.getRequestUrl();
            }
            LOGGER.info(getClass() + " 获取登陆之前的URL:[%s], " + url);
            if (StringUtils.isEmpty(url)) {
                url = "/user/index";
            }
            resultMap.put("back_url", url);
        } catch (DisabledAccountException e) {
            throw new ServiceException(ServiceCode.ACCOUNT_LOCK, "账号已经被锁定");
        } catch (Exception e) {
            throw new ServiceException(ServiceCode.USERNAME_PWD_ERROR, "用户名或密码错误");
        }
        return ResultBean.format(resultMap);
    }

    @RequestMapping(value = "/user/index", method = RequestMethod.GET)
    public ModelAndView userIndex() {
        return new ModelAndView("user/index");
    }
}
