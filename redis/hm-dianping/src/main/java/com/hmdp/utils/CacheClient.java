package com.hmdp.utils;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.hmdp.utils.RedisConstants.*;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-06-25 17:29
 * @description:
 **/
@Component
@Slf4j
public class CacheClient {
	private final StringRedisTemplate stringRedisTemplate;

	public CacheClient(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	public void set(String key, Object value, Long timeout, TimeUnit unit) {
		stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value), timeout, unit);
	}

	public void setWithLogicalExpire(String key, Object value, Long timeout, TimeUnit unit) {
		RedisData redisData = new RedisData();
		redisData.setData(value);
		redisData.setExpireTime(LocalDateTime.now().plusSeconds(unit.toSeconds(timeout)));
		//写入redis
		stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(redisData));
	}

	public <R, ID> R queryWithPassThrough(String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallback, Long timeout, TimeUnit unit) {//泛型推断
		String key = keyPrefix + id;
		// 1.从redis查询商铺缓存
		String json = stringRedisTemplate.opsForValue().get(key);
		//2.判断是否存在
		if (StrUtil.isNotBlank(json)) {
			//3.存在，直接返回
			return JSONUtil.toBean(json, type);
		}
		//命中的是否是空值
		if (json != null) {
			//返回错误信息
			return null;
		}
		//4.不存在，根据id查询数据库
		//由于这里不确定要查什么，所以不知道查询的函数
		//所以用函数式接口，有用户指定查询的方法Function<ID, R> dbFallback：：ID 参数 R 返回值
		R r = dbFallback.apply(id);
		//5.不存在，返回错误
		if (r == null) {
			//将null写入redis
			stringRedisTemplate.opsForValue().set(key, "", CACHE_NULL_TTL, TimeUnit.MINUTES);
			return null;
		}
		//6.存在，写入redis，设置有效期（timeout）30分钟
		this.set(key, r, timeout, unit);
		//7.返回
		return r;
	}


	private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);

	//基于redis::setnx()获取锁
	private boolean tryLock(String key) {
		//redis::setnx(), 当且仅当不存在时，才能设置key和值
		Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", LOCK_SHOP_TTL, TimeUnit.SECONDS);
		return BooleanUtil.isTrue(flag);
	}

	//删除锁
	public void unLock(String key) {
		stringRedisTemplate.delete(key);
	}

	public <R, ID> R queryWithLogicalExpire(String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallback, Long timeout, TimeUnit unit) {
		String key = keyPrefix + id;
		// 1.从redis查询商铺缓存
		String shopJson = stringRedisTemplate.opsForValue().get(key);
		//2.判断是否存在
		if (StrUtil.isBlank(shopJson)) {
			//3.不存在，返回null
			return null;
		}
		//4.存在，将json反序列化为对象
		RedisData redisData = JSONUtil.toBean(shopJson, RedisData.class);
		JSONObject data = (JSONObject) redisData.getData();
		R r = JSONUtil.toBean(data, type);
		LocalDateTime expireTime = redisData.getExpireTime();
		//5.判断是否过期
		if (expireTime.isAfter(LocalDateTime.now())) {
			//5.1.未过期，返回商铺信息
			return r;
		}
		//5已过期，需要缓存重建
		//5.1获取互斥锁
		String lockKey = LOCK_SHOP_KEY + id;
		boolean isLock = tryLock(lockKey);
		//5.2判断锁是否获取成功
		if (isLock) {
			//5.3成功，开启独立线程，开启缓存重建 使用线程池
			CACHE_REBUILD_EXECUTOR.submit(() -> {
				try {
					//查询数据库
					R newR = dbFallback.apply(id);
					//重建缓存
					this.setWithLogicalExpire(key, newR, timeout, unit);
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {
					//释放锁
					unLock(lockKey);
				}
			});
		}

		//5.4返回过期商铺信息
		return r;
	}
}
