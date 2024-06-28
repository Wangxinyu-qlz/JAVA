package com.hmdp.utils;

import cn.hutool.core.lang.UUID;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-28 16:46
 * @description:
 **/
public class SimpleRedisLock implements ILock {
	private StringRedisTemplate stringRedisTemplate;
	private static final String KEY_PREFIX = "lock:";
	//保证id的全局唯一性
	private static final String ID_PREFIX = UUID.randomUUID().toString(true) + "-";
	private String name;//不同的业务应该有不同的锁

	public SimpleRedisLock(StringRedisTemplate stringRedisTemplate, String name) {
		this.stringRedisTemplate = stringRedisTemplate;
		this.name = name;
	}

	@Override
	public boolean tryLock(Long timeoutSec) {
		//获取线程的标识
		String threadId = ID_PREFIX + Thread.currentThread().getId();
		//获取锁
		String key = KEY_PREFIX + name;
		Boolean success = stringRedisTemplate.opsForValue().setIfAbsent(key, threadId, timeoutSec, TimeUnit.SECONDS);
		//返回值是基本类型，success是包装类型，拆箱可能会空指针
		return Boolean.TRUE.equals(success);
	}

	@Override
	public void unlock() {
		//获取线程的标识
		String threadId = ID_PREFIX + Thread.currentThread().getId();
		//获取锁中的标识
		String id = stringRedisTemplate.opsForValue().get(KEY_PREFIX + name);
		//判断标识
		if (threadId.equals(id)) {
			//释放锁
			stringRedisTemplate.delete(KEY_PREFIX + name);
		}
	}
}
