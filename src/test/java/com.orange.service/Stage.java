/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.service;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/7/3
 * @description
 */
public class Stage {
    private static int getSteps(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return getSteps(n - 1) + getSteps(n - 2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(getSteps(50));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
