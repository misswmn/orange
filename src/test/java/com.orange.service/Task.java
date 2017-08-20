package com.orange.service;

import java.util.concurrent.Callable;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/14
 * @description
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        return fibc(20) + "";
    }

    int fibc(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibc(num - 1) + fibc(num - 2);
    }
}
