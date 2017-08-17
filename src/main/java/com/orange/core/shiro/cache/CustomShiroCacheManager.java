package com.orange.core.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

import javax.inject.Inject;

/**
 * @author wangmn
 * @date 2017/8/6
 */
public class CustomShiroCacheManager implements CacheManager, Destroyable {
    @Inject
    private ShiroCacheManager jedisShiroCacheManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return null;
    }

    @Override
    public void destroy() throws Exception {

    }
}
