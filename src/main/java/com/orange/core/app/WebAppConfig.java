package com.orange.core.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * Created by misswmn on 2016/12/27.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.orange.core"}, excludeFilters = @ComponentScan.Filter(pattern = "com.orange.core.controller", type = FilterType.REGEX))
@PropertySource(value = {"classpath:/orange.properties"})
public class WebAppConfig {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private String port;

    @PostConstruct
    private void init() {
        System.out.println(this.host);
    }
}
