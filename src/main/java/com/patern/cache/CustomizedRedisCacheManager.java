package com.patern.cache;

import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;

public class CustomizedRedisCacheManager<K,V> extends RedisCacheManager{

	/**
     * 缓存参数的分隔符
     * 数组元素0=缓存的名称
     * 数组元素1=缓存过期时间TTL
     * 数组元素2=缓存在多少秒开始主动失效来强制刷新
     */
//    private String separator = "#";

    /**
     * 缓存主动在失效前强制刷新缓存的时间
     * 单位：秒
     */
//    private long preloadSecondTime=0;
	
	public CustomizedRedisCacheManager(RedisOperations<K,V> redisOperations) {
		super(redisOperations);
	}

}
