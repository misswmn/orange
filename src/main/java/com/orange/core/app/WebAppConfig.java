package com.orange.core.app;

import com.orange.core.client.JedisClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by misswmn on 2016/12/27.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.orange.core"}, excludeFilters = @ComponentScan.Filter(pattern = "com.orange.core.controller", type = FilterType.REGEX))
@PropertySource(value = {"classpath:/orange.properties"})
public class WebAppConfig {

    //    @Value("${redis.host}")
    private String host = "99.48.18.212";
    //    @Value("${redis.port}")
    private int port = 6379;
    //    @Value("${redis.timeout}")
    private int redisTimeout = 50_000;
    //    @Value("${redis.password}")
    private String redisPassword = "1qaz@WSX";
    //    @Value("${redis.database}")
    private int redisDatabase = 0;

    //    @Value("${redis.pool.maxIdle}")
    private int redisMaxIdle = 50_000;
    //    @Value("${redis.pool.minIdle}")
    private int redisMinIdle = 50_000;
    //    @Value("${redis.pool.maxTotal}")
    private int redisMaxTotal = 50;
    //    @Value("${redis.pool.maxWaitMillis}")
    private int redisMaxWaitMillis = 50_000;

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
