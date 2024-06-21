package com.qlz.springdataredisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlz.springdataredisdemo.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
class RedisStringTests {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	void testString() {
		stringRedisTemplate.opsForValue().set("address", "北京");
		System.out.println(stringRedisTemplate.opsForValue().get("address"));
	}

	private static final ObjectMapper mapper = new ObjectMapper();
	@Test
	public void testSaveUser() throws JsonProcessingException {
		//创建对象
		User user = new User("qlz", 12);
		//手动序列化
		String json = mapper.writeValueAsString(user);
		//{\"name\":\"qlz\",\"age\":12}
		stringRedisTemplate.opsForValue().set("user:100", json);
		//获取数据
		String json2 = stringRedisTemplate.opsForValue().get("user:100");
		//手动反序列化
		User user2 = mapper.readValue(json2, User.class);
		System.out.println("user=" + user2);
	}

	@Test
	public void testHash() {
		stringRedisTemplate.opsForHash().put("user:200", "name", "qlz");
		//TODO 这里必须是string 数字也是string
		stringRedisTemplate.opsForHash().put("user:200", "age", "12");

		Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:200");
		System.out.println(entries);
	}
}

