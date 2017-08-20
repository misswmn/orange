package com.orange.core.spring.bean;

import com.orange.core.spring.SpELAssert;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/22
 * @description
 */
public class SampleSpring {

    @SpELAssert("@myService.calculate(#this) > 42")
    private int value;
}