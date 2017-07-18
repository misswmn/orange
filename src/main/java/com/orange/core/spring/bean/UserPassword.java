/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.spring.bean;

import com.orange.core.spring.SpELAssert;

import javax.validation.constraints.NotNull;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/22
 * @description
 */
@SpELAssert(value = "newPassword != null && newPassword.equals(confirmPassword)",
        message = "{validator.passwords_not_same}")
public class UserPassword {

    @NotNull(message = "新密码不能为空1")
    private String newPassword;
    @NotNull(message = "新密码不能为空2")
    private String confirmPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public static void main(String[] args) {
        String oldPassword = "a";
        String newPassword = null;
        boolean f = oldPassword != null && oldPassword.equals(newPassword);
        System.out.println(f);
    }
}