package com.orange.service;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/27
 * @description
 */
public class Box<T> {
    private T data;

    public Box() {

    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
