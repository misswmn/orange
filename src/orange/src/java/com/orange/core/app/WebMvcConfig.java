package com.orange.core.app;

import freemarker.template.utility.XmlEscape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by misswmn on 2016/12/27.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.orange.*.web"}, lazyInit = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static final Charset charset = Charset.forName("UTF-8");

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/demo/**").addResourceLocations("/demo/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setSupportedMediaTypes(Arrays.asList(
                new MediaType("text", "plain", charset),
                new MediaType("*", "*", charset),
                new MediaType("text", "*", charset),
                new MediaType("application", "json", charset)
        ));
        return jsonConverter;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> converterList = new ArrayList<>();
        converterList.add(mappingJackson2HttpMessageConverter());
        handlerAdapter.setMessageConverters(converterList);
        return handlerAdapter;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(1024 * 50L);
        return resolver;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(org.springframework.web.servlet.view.InternalResourceView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(1);
        return viewResolver;
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
    public XmlEscape xmlEscape() {
        return new XmlEscape();
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
        settings.put("auto_import", "common/config/top.ftl as _top," +
                "common/config/left.ftl as _left," +
                "common/config/menu.ftl as _menu"
        );
        configurer.setFreemarkerSettings(settings);
        return configurer;
    }
}