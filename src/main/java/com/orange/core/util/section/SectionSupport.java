/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.util.section;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/4/21
 * @description
 */
public class SectionSupport {
    public static void qsort(Section[] sections, int low, int high) {
        int i = low;
        int j = high;
        Section temp = sections[low];
        while (i < j) {
            while (i < j && Integer.parseInt(temp.getMinValue()) < Integer.parseInt(sections[j].getMinValue()))
                j--;
            if (i < j) {
                sections[i] = sections[j];
                i++;
            }
            while (i < j && Integer.parseInt(temp.getMinValue()) > Integer.parseInt(sections[i].getMinValue()))
                i++;
            if (i < j) {
                sections[j] = sections[i];
                j--;
            }
        }
        sections[i] = temp;
        if (low < i) {
            qsort(sections, low, i - 1);
        }
        if (high > j) {
            qsort(sections, j + 1, high);
        }
    }
}
