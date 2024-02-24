package com.dailyalgo.codeExecutor.application.common.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CacheService {

	private final RedisTemplate<String, String> redisTemplate;

	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public void set(String key, String value, int expireMinutes) {
		redisTemplate.opsForValue().set(key, value, expireMinutes);
	}

	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public boolean del(String key) {
		return Boolean.TRUE.equals(redisTemplate.delete(key));
	}

}
