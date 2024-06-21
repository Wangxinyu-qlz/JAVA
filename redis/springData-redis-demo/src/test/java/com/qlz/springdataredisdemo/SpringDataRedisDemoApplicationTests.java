package com.qlz.springdataredisdemo;

import com.qlz.springdataredisdemo.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringDataRedisDemoApplicationTests {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	void testString() {
		redisTemplate.opsForValue().set("address", "北京");
		System.out.println(redisTemplate.opsForValue().get("address"));
	}

	@Test
	public void testSaveUser() {
		redisTemplate.opsForValue().set("user:100", new User("qlz", 12));
		//获取数据
		User user = (User)redisTemplate.opsForValue().get("user:100");
		System.out.println("user=" + user);
	}
}

