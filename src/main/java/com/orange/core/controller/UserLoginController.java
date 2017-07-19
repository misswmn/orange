package com.orange.core.controller;

import com.orange.core.domain.user.UserDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by misswmn on 2017/4/8.
 */
@RestController(value = "/u")
public class UserLoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Validated @RequestBody UserDTO user, Errors result) {
        if (result.hasErrors()) {
            List<ObjectError> ls = result.getAllErrors();
            for (int i = 0; i < ls.size(); i++) {
                System.out.println("error:" + ls.get(i).getDefaultMessage());
            }
            return "error";
        }
        return "success";
    }
}
