package com.orange.core.controller;

import com.orange.core.domain.user.UserParam;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by misswmn on 2017/4/8.
 */
@RestController(value = "/u")
@Validated
public class UserLoginController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid UserParam user, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        return "success";
    }
}
