package com.orange.core.shiro.cache;

import com.orange.core.util.JedisClient;
import org.apache.shiro.cache.Cache;

import javax.inject.Inject;

/**
 * @author wangmn
 * @date 2017/8/6
 */
public class JedisShiroCacheManager implements ShiroCacheManager {
    @Inject
    private JedisClient jedisClient;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return null;
    }

    @Override
    public void destroy() {

    }
}
