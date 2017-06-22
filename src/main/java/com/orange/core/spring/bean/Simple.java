/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.spring.bean;

import com.orange.core.spring.SpELAssert;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/22
 * @description
 */
public class Simple {

    @SpELAssert(value = "#isEven(#this) && #this > 42",
            helpers = Helpers.class)
    private int count;
}