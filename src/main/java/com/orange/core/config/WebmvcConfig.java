/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.orange.core.config;

import freemarker.template.utility.XmlEscape;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/16
 * @description
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.orange.core.controller")
public class WebmvcConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:ValidationMessages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setProviderClass(HibernateValidator.class);
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        processor.setValidator(validator());
        return processor;
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setViewClass(org.springframework.web.servlet.view.freemarker.FreeMarkerView.class);
        viewResolver.setContentType("text/html;charset=utf-8");
        viewResolver.setSuffix(".ftl");
        viewResolver.setOrder(0);
        return viewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/ftl/");
        configurer.setDefaultEncoding("UTF-8");
        Map<String, Object> variables = new HashMap<>();
        variables.put("xml_escape", xmlEscape());
        configurer.setFreemarkerVariables(variables);
        Properties settings = new Properties();
        settings.put("template_update_delay", "3600");
        settings.put("locale", "zh_CN");
        settings.put("datetime_format", "yyyy-MM-dd HH:mm:ss");
        settings.put("date_format", "yyyy-MM-dd");
        settings.put("number_format", "#.##");
        configurer.setFreemarkerSettings(settings);
        return configurer;
    }

    @Bean
    public XmlEscape xmlEscape() {
        return new XmlEscape();
    }
}
