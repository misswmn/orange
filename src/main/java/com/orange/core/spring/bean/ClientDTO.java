/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.spring.bean;

import com.orange.core.spring.SpELAssert;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Collection;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/22
 * @description
 */
@SpELAssert(value = "hasRedirectUris()", applyIf = "grantTypes.contains('auth_code')",
        message = "{validator.missing_redirect_uri}")
public class ClientDTO {

    @NotEmpty(message = "clientDTO.grantTypes 是空的")
    private Collection<String> grantTypes;
    private Collection<String> redirectUris;

    public boolean hasRedirectUris() {
        return !redirectUris.isEmpty();
    }

    public Collection<String> getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(Collection<String> grantTypes) {
        this.grantTypes = grantTypes;
    }

    public Collection<String> getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(Collection<String> redirectUris) {
        this.redirectUris = redirectUris;
    }
}