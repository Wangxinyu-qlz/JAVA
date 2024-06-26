package com.hmdp.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-26 10:28
 * @description: id 生成器
 **/
@Component
public class RedisIdWorker {
	//开始时间戳
	private static final long BEGIN_TIMESTAMP = 1719397800L;
	private static final int COUNT_BITS = 32;
	//redis
	private StringRedisTemplate stringRedisTemplate;
	public RedisIdWorker(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	public long nextId(String keyPrefix) {//业务前缀
		//生成时间戳
		LocalDateTime now = LocalDateTime.now();
		long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
		long timestamp = nowSecond - BEGIN_TIMESTAMP;
		//生成序列号
		//获取当前日期，精确到天
		//方便统计，redis使用:区分业务
		String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
		Long count = stringRedisTemplate.opsForValue().increment("icr:" + keyPrefix + ":" + date);
		//拼接返回
		//时间戳左移32位，拼接序列号(|或运算，00==0 01==1)
		return timestamp << COUNT_BITS | count;
	}

	public static void main(String[] args) {
		LocalDateTime time = LocalDateTime.of(2024, 6, 26, 10, 30, 0);
		long second = time.toEpochSecond(ZoneOffset.UTC);
		System.out.println(second);
	}
}
