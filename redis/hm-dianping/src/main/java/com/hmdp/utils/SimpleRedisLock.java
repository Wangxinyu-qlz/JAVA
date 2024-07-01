package com.hmdp.utils;

import cn.hutool.core.lang.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;
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

	private static final DefaultRedisScript<Long> UNLOCK_SCRIPT;
	static {
		UNLOCK_SCRIPT = new DefaultRedisScript<>();
		UNLOCK_SCRIPT.setLocation(new ClassPathResource("unLock.lua"));
		UNLOCK_SCRIPT.setResultType(Long.class);
	}

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

	//释放锁
	@Override
	public void unlock() {
		//调用lua返回值
		stringRedisTemplate.execute(UNLOCK_SCRIPT,
				Collections.singletonList(KEY_PREFIX + name),
				ID_PREFIX + Thread.currentThread().getId());
	}

	/*	//释放锁，无法保证原子性
	@Override
	public void unlock() {
		//获取线程的标识
		String threadId = ID_PREFIX + Thread.currentThread().getId();
		//获取锁中的标识
		String id = stringRedisTemplate.opsForValue().get(KEY_PREFIX + name);
		//以下两个操作必须原子性，否则会出现JVM垃圾回收释放锁阻塞，锁被超时释放
		//其他线程加锁执行，当前直接执行释放锁（因为已经判断过了），就会出现锁被提前释放
		//判断标识
		if (threadId.equals(id)) {
			//释放锁
			stringRedisTemplate.delete(KEY_PREFIX + name);
		}
	}*/
}
