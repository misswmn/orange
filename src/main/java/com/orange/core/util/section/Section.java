/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.util.section;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/4/20
 * @description 区间字典转换
 */
public class Section {
    /**
     * 匹配区间字符串
     */
    private static final Pattern PATTERN = Pattern.compile("(\\[|\\()(\\+|\\d+)(,)(\\d+|\\+)(\\]|\\))");
    /**
     * 左区间[ or (
     */
    private String leftToken;
    /**
     * 左区间点
     */
    private String minValue;
    /**
     * 右区间点
     */
    private String maxValue;
    /**
     * 右区间] or )
     */
    private String rightToken;

    /**
     * 区间对应的值
     */
    private String message;

    /**
     * 特殊值
     */
    private Map<String, String> constantMap;

    public Section(String string, String message) {
        string = string.replaceAll(" ", "");
        Matcher matcher = PATTERN.matcher(string);
        if (matcher.find()) {
            this.leftToken = matcher.group(1);
            this.minValue = matcher.group(2);
            this.maxValue = matcher.group(4);
            this.rightToken = matcher.group(5);
            this.message = message;
        } else {
            if (this.constantMap == null) {
                this.constantMap = new HashMap<>();
            }
            constantMap.put(string, message);
        }
    }

    public String getLeftToken() {
        return leftToken;
    }

    public void setLeftToken(String leftToken) {
        this.leftToken = leftToken;
    }

    public String getMinValue() {
        return minValue == null ? null : ("+".equalsIgnoreCase(minValue) ? Integer.MIN_VALUE + "" : minValue);
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue == null ? null : ("+".equalsIgnoreCase(maxValue) ? Integer.MAX_VALUE + "" : maxValue);
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getRightToken() {
        return rightToken;
    }

    public void setRightToken(String rightToken) {
        this.rightToken = rightToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getConstantMap() {
        return constantMap;
    }

    public void setConstantMap(Map<String, String> constantMap) {
        this.constantMap = constantMap;
    }

    /**
     * 初始化
     *
     * @param dictMap 字典项
     */
    public static List<Section> init(Map<String, String> dictMap) {
        return dictMap.entrySet().stream()
                .map(entry -> new Section(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * 初始化
     *
     * @param dictMap 字典项
     * @param value   需转换的值
     */
    public static String getValue(Map<String, String> dictMap, String value) {
        List<Section> sectionList = Section.init(dictMap);
        {
            String result = Section.getValue(sectionList, Integer.parseInt(value));
            if (result != null) return result;
        }
        {
            Section[] sections = sectionList.stream()
                    .filter(s -> s.constantMap == null)
                    .toArray(Section[]::new);
            SectionSupport.qsort(sections, 0, sections.length - 1);
            return Section.getValue(sections, 0, sections.length - 1, Integer.parseInt(value));
        }
    }

    /**
     * 取特殊值
     */
    private static String getValue(List<Section> sectionList, Integer value) {
        return sectionList.stream()
                .filter(s -> s.constantMap != null)
                .filter(s -> s.constantMap.containsKey(value + ""))
                .map(s -> s.constantMap.get(value + ""))
                .findFirst().orElse(null);
    }

    /**
     * 区间判断
     */
    private boolean getValue(Integer value, boolean onlyLeft) {
        boolean left = false, right = false;
        switch (this.leftToken) {
            case "[":
                left = value >= Integer.parseInt(this.getMinValue());
                break;
            case "(":
                left = value > Integer.parseInt(this.getMinValue());
                break;
        }
        if (onlyLeft) {
            return left;
        }
        switch (this.rightToken) {
            case "]":
                right = value <= Integer.parseInt(this.getMaxValue());
                break;
            case ")":
                right = value < Integer.parseInt(this.getMaxValue());
                break;
        }
        return left && right;
    }

    private static String getValue(Section[] sections, int min, int max, Integer value) {
        while (min <= max) {
            int middle = (min + max) / 2;
            if (sections[middle].getValue(value, true)) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }

        if (sections[max].getValue(value, false)) {
            return sections[max].getMessage();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Map<String, String> dictMap = new HashMap<>();
        {
            dictMap.put("(+,99]", "很低");
            dictMap.put("[100,199]", "低");
            dictMap.put("[200,299]", "中");
            dictMap.put("[300,399]", "中高");
            dictMap.put("[400,499]", "高");
            dictMap.put("[500,599)", "很高");
            dictMap.put("9990", "特殊值(极有可能)");
            dictMap.put("9991", "特殊值(没有可能)");
        }
        String result = Section.getValue(dictMap, "9990");
        System.out.println(result);
    }
}
