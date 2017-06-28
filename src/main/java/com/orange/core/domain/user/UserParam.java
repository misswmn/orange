/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.domain.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/15
 * @description
 */
public class UserParam {
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 5, max = 20)
    @Pattern(regexp = "^[a-zA-Z]{5,20}$", message = "用户名格式不正确")
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;

    @NotEmpty(message = "{common.param.illegal}")
    private List<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("messages");
        System.out.print(resource.getString("name.not.empty"));
    }
}
