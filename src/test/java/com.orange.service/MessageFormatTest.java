package com.orange.service;

import com.orange.core.util.JsonUtils;
import org.junit.Test;

import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/26
 * @description
 */
public class MessageFormatTest {

    public static void main(String[] args) {

    }

    @Test
    public void a() {
        MessageFormat mf = new MessageFormat("{0}, {0}, {0}");
        String forParsing = "x, y, z";
        Object[] objs = mf.parse(forParsing, new ParsePosition(0));
        // result now equals {new String("z")}
    }

    @Test
    public void b() {
        String message = "{0}{1}{2}{3}{4}{5}{6}{7}{8}{9}{10}{11}{12}{13}{14}{15}{16}";
        Object[] array = new Object[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q"};
        String value = MessageFormat.format(message, array);
        System.out.println(value);
    }

    @Test
    public void c() {
        String message = "oh, {0} is 'a' pig";
        Object[] array = new Object[]{"ZhangSan"};
        String value = MessageFormat.format(message, array);
        System.out.println(value);
    }

    @Test
    public void d() {
        String message = "oh, '{0}' is 'a' pig";
        Object[] array = new Object[]{"ZhangSan"};
        String value = MessageFormat.format(message, array);
        System.out.println(value);
    }

    @Test
    public void e() {
        String message = "oh, {0,number,#.#####} is a pig";
        Object[] array = new Object[]{new Double(3.1415)};
        String value = MessageFormat.format(message, array);
        System.out.println(value);
    }

    @Test
    public void f() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("124");
        copy(list);
        System.out.println(JsonUtils.objectToJson(list));
    }

    private static void copy(List list) {
        list.add(false);
    }
}
