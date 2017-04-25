package com.orange.core.app;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by misswmn on 2017/1/2.
 */
@Configuration
public class AppDataConfig {

    @Value("${jdbc.url}")
    private String jdbcurl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driverClassName}")
    private String driverClass;
    @Value("${jdbc.initialSize}")
    private int initialSize;
    //    @Value("${jdbc.maxActive}")
    private int maxActive = 20;
    @Value("${jdbc.minIdle}")
    private int minIdle;
    @Value("${jdbc.maxWait}")
    private int maxWait;
    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${jdbc.validationQuery}")
    private String validationQuery;
    @Value("${jdbc.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${jdbc.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${jdbc.testOnReturn}")
    private boolean testOnReturn;
    @Value("${jdbc.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${jdbc.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${jdbc.filters}")
    private String filters;

    @Value("${jdbc.filters}")
    private String domain;

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws SQLException {
        System.out.println("domain:" + domain);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcurl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setFilters(filters);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.orange.core.domain");
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.orange.core.dao");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return configurer;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesEnv() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
