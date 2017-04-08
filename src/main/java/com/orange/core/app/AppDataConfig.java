package com.orange.core.app;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by misswmn on 2017/1/2.
 */
@Configuration
@ComponentScan(basePackages = {"com.orange.*.controller", "com.orange.*.*.controller", "com.orange.*.tags"}, lazyInit = true)
@PropertySource("classpath:/jdbc.properties")
public class AppDataConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppDataConfig.class);
    @Value("${jdbc.url}")
    private String jdbcurl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driverClassName}")
    private String driverClass;
    @Value("${jdbc.initialSize}")
    private String initialSize;
    @Value("${jdbc.maxActive}")
    private String maxActive;
    @Value("${jdbc.minIdle}")
    private String minIdle;
    @Value("${jdbc.maxWait}")
    private String maxWait;

    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/orange");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setFilters("stat");
        dataSource.setInitialSize(1);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60 * 1000);
        dataSource.setMinIdle(1);
        dataSource.setTimeBetweenEvictionRunsMillis(60 * 1000);
        dataSource.setMinEvictableIdleTimeMillis(30 * 1000);
        dataSource.setValidationQuery("SELECT 'x' FROM ");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(50);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.orange.*.model");
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.orange.*.dao");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return configurer;
    }
}
