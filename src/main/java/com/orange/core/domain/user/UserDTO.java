package com.orange.core.domain.user;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/27
 * @description
 */
public class UserDTO {
    @NotEmpty(message = "{common.param.illegal}")
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
