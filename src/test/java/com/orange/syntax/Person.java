package com.orange.syntax;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/15
 * @description
 */
public class Person {
    @NotNull(message = "name can not be blank")
    String name;
    @Min(value = 18, message = "年龄最小18岁")
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}