package com.orange.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ex-wangmengnan
 * @date 2017/8/31
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET, name = "登录页")
    public ModelAndView index() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET, name = "跳转到首页")
    public ModelAndView main() {
        return new ModelAndView("main");
    }
}