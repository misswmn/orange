package com.orange.core.controller;

import com.alibaba.druid.util.StringUtils;
import com.orange.core.common.ResultBean;
import com.orange.core.domain.user.UserParam;
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
    public ResultBean login(@Valid UserParam user, BindingResult result,
                            Boolean rememberMe, HttpServletRequest request) {
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
        return ResultBean.format(resultMap);
    }
}
