package com.reactwebflux.config;

import java.util.Collections;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

	@Bean
	public CacheManager employeeCacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("employeeUserCache")));
		//this employeeUserCache we are using in the  service layer @Cacheable(value = "employeeUserCache", cacheManager="employeeCacheManager", sync = true)
		return cacheManager;

	}

}
