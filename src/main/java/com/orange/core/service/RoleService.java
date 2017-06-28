/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.service;

import com.orange.core.spring.bean.Role;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/26
 * @description
 */
@Validated
public interface RoleService {
    void saveOne(@Valid Role role);
}
