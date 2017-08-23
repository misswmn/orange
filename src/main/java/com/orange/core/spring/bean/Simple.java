package com.orange.core.spring.bean;

import com.orange.core.spring.SpELAssert;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/22
 * @description
 */
public class Simple {

    @SpELAssert(value = "#validChannel(#this)", helpers = Helpers.class, message = "{simple.count.even}")
    private int count;
}