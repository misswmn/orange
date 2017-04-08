package com.orange.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by misswmn on 2017/4/8.
 */
@RestController(value = "/login")
public class LoginController {

    @RequestMapping(value = "/index")
    public void index() {

    }
}
