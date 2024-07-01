package com.hmdp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-07-01 16:38
 * @description:
 **/
@Slf4j
@SpringBootTest
public class RedissonTest {
	@Resource
	private RedissonClient redissonClient;

	private RLock lock;

	//获取当前时间

	@BeforeEach
	void setUp() {
		lock = redissonClient.getLock("order");
	}

	@Test
	public void method1() throws InterruptedException {
		boolean isLock = lock.tryLock(1L, TimeUnit.SECONDS);
		if(!isLock) {
			log.error("获取锁失败，1");
			return;
		}
		try {
			log.info("获取锁成功，1");
			method2();
			log.info("执行业务，1");
		} finally {
			log.info("释放锁，1");
			lock.unlock();
		}

	}

	@Test
	public void method2() {
		boolean isLock = lock.tryLock();
		if(!isLock) {
			log.error("获取锁失败，2");
			return;
		}
		try {
			log.info("获取锁成功，2");
			log.info("执行业务，2");
		}
		finally {
			log.info("释放锁，2");
			lock.unlock();
		}
	}
}
