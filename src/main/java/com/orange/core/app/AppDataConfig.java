package com.orange.core.app;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by misswmn on 2017/1/2.
 */
@Configuration
@PropertySource(value = {"classpath:orange.properties"})
public class AppDataConfig {
    @Value("${jdbc.url}")
    private String jdbcurl = "jdbc:mysql://localhost:3306/orange";
    @Value("${jdbc.username}")
    private String username = "root";
    @Value("${jdbc.password}")
    private String password = "";
    @Value("${jdbc.driverClassName}")
    private String driverClass = "com.mysql.jdbc.Driver";
    @Value("${jdbc.initialSize}")
    private int initialSize = 3;
    @Value("${jdbc.maxActive}")
    private int maxActive = 6000;
    @Value("${jdbc.minIdle}")
    private int minIdle = 6000;
    @Value("${jdbc.maxWait}")
    private int maxWait = 6000;
    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis = 60000;
    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis = 30000;
    @Value("${jdbc.validationQuery}")
    private String validationQuery = "select 'x' ";
    @Value("${jdbc.testWhileIdle}")
    private boolean testWhileIdle = true;
    @Value("${jdbc.testOnBorrow}")
    private boolean testOnBorrow = true;
    @Value("${jdbc.testOnReturn}")
    private boolean testOnReturn = false;
    @Value("${jdbc.poolPreparedStatements}")
    private boolean poolPreparedStatements = true;
    @Value("${jdbc.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize = 20;
    @Value("${jdbc.filters}")
    private String filters = "stat";

    @Bean
    public DataSource dataSource() throws SQLException {
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
}
