/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.domain.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/15
 * @description
 */
public class UserParam implements Serializable {
    private static final long serialVersionUID = -5571594707748295195L;
    /**
     * 用户名
     */
    @NotEmpty(message = "{user.name.null}")
    @Length(min = 5, max = 20, message = "{user.name.length.illegal}")
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "{user.name.illegal}")
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "{user.password.null}")
    private String password;

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
}
