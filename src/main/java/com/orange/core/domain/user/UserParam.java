package com.orange.core.domain.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/15
 * @description
 */
public class UserParam {

    /**
     * 编号
     */
    private Long id;
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z]{5,20}$", message = "用户名格式不正确")
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;

    private Long status;

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
