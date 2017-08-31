package com.orange.core.controller;

import com.orange.core.business.LoginBusiness;
import com.orange.core.common.ResultBean;
import com.orange.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by misswmn on 2017/4/8.
 */
@RestController(value = "/u")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Inject
    private LoginBusiness loginBusiness;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean login(HttpServletRequest request, @Valid User user, BindingResult result) {
        return ResultBean.format(loginBusiness.login(request, user));
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("main");
    }
}
