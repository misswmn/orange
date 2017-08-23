package com.orange.core.spring.bean;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/22
 * @description
 */
public final class Helpers {

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    public static boolean validChannel(Integer value) {
        return value.intValue() > 1 && value.intValue() < 7;
    }
}