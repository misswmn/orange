package com.orange.core.shiro.cache;

import org.apache.shiro.cache.Cache;

/**
 * @author wangmn
 * @date 2017/8/6
 */
public interface ShiroCacheManager {

    <K, V> Cache<K, V> getCache(String name);

    void destroy();
}
