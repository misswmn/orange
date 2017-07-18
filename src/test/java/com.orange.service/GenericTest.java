/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/27
 * @description
 */
public class GenericTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericTest.class);
    public static void main(String[] args) {
        Box<String> name = new Box<>("corn");
        Box<Integer> age = new Box<>(712);
        Box<Number> number = new Box<>(314);
        Box<Object> obj = new Box<>(new Object[]{1, 2, 3, 4});
        {
//            getData(name);
//            getData(age);
//            getData(number);
//            getData(obj);

            getUpperNumberData(age);
            getLowerNumberData(age);
        }
    }

    private static void getData(Box data) {
        System.out.println("data :" + data.getData());
    }

    private static void getData2(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

    private static void getUpperNumberData(Box<? extends Integer> data) {
        System.out.println("data :" + data.getData());
    }

    private static void getLowerNumberData(Box<? super Integer> data) {
        System.out.println("data :" + data.getData());
    }

    @Test
    public void test() {
        boolean f = true && false || false;
        System.out.println(f);
    }

    @Test
    public void test2(){
        LOGGER.info("{},{},{}", "xxxx", "aaaa","精品房但是");
    }
}
