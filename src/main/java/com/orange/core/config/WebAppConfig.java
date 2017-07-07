package com.orange.core.config;

import com.orange.core.client.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by misswmn on 2016/12/27.
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySources(
        @PropertySource(value = {"classpath:orange.properties"})
)
@ComponentScan(basePackages = "com.orange.core", lazyInit = true, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = {Controller.class, ControllerAdvice.class, RestController.class})})
@Import({AppDatabaseConfig.class})
public class WebAppConfig {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.timeout}")
    private int redisTimeout;
    @Value("${redis.password}")
    private String redisPassword;
    @Value("${redis.database}")
    private int redisDatabase;

    @Value("${redis.pool.maxIdle}")
    private int redisMaxIdle;
    @Value("${redis.pool.minIdle}")
    private int redisMinIdle;
    @Value("${redis.pool.maxTotal}")
    private int redisMaxTotal;
    @Value("${redis.pool.maxWaitMillis}")
    private int redisMaxWaitMillis;

    @Autowired
    private Environment env;

    @Bean
    public JedisClient jedisClient() {
        JedisClient jedisClient = new JedisClient();
        jedisClient.setJedisPool(jedisPool());
        return jedisClient;
    }

    private JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisMaxIdle);
        jedisPoolConfig.setMinIdle(redisMinIdle);
        jedisPoolConfig.setMaxTotal(redisMaxTotal);
        jedisPoolConfig.setMaxWaitMillis(redisMaxWaitMillis);
        return new JedisPool(jedisPoolConfig, host, port, redisTimeout, redisPassword, redisDatabase);
    }
}
