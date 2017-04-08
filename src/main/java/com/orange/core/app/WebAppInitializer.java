package com.orange.core.app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by misswmn on 2016/12/27.
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppDataConfig.class, WebAppConfig.class);
        container.addListener(new ContextLoaderListener(context));

        context.register(WebMvcConfig.class);
        ServletRegistration.Dynamic dispatcher = container.addServlet("orange", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(3);
        dispatcher.addMapping("*.shtml");
        container.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true)).addMappingForUrlPatterns(null, true, "/*");
    }
}
