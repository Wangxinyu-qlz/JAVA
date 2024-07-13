package com.sky.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-13 10:25
 * @description:
 **/
//@SpringBootTest
public class SpringDataRedisTest {
	//@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testRedisTemplate() {
		System.out.println(redisTemplate);
		ValueOperations valueOperations = redisTemplate.opsForValue();
		HashOperations hashOperations = redisTemplate.opsForHash();
		ListOperations listOperations = redisTemplate.opsForList();
		SetOperations setOperations = redisTemplate.opsForSet();
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
	}

	/**
	 * 操作字符串类型的数据
	 */
	@Test
	public void testString() {
		//set get setex(设置有效期expire time) setnx(没有才插入)
		redisTemplate.opsForValue().set("city", "北京");
		String city = (String) redisTemplate.opsForValue().get("city");
		System.out.println(city);
		redisTemplate.opsForValue().set("code", "123456", 60 * 10, TimeUnit.SECONDS);
		redisTemplate.opsForValue().setIfAbsent("lock", "1");
		redisTemplate.opsForValue().setIfAbsent("lock", "2");//不生效

		redisTemplate.opsForValue().set("city", "1");
	}

	/**
	 * 操作hash类型的数据
	 */
	@Test
	public void testHash() {
		//hset hget hdel hkeys hvals
		HashOperations hashOperations = redisTemplate.opsForHash();
		hashOperations.put("user:1", "name", "张三");
		hashOperations.put("user:1", "age", "20");
		String name = (String) hashOperations.get("user:1", "name");
		System.out.println(name);//张三

		Set keys = hashOperations.keys("user:1");
		System.out.println(keys);//[name, age]

		List values = hashOperations.values("user:1");
		System.out.println(values);//[张三, 20]

		hashOperations.delete("user:1", "age");
	}

	/**
	 * 操作list类型的数据
	 */
	@Test
	public void testList() {
		//lpush lrange rpop llen
		ListOperations listOperations = redisTemplate.opsForList();
		listOperations.leftPushAll("mylist", "a", "b", "c");
		listOperations.leftPush("mylist", "d");

		List mylist = listOperations.range("mylist", 0, -1);
		System.out.println(mylist);  //[d, c, b, a]

		listOperations.rightPop("mylist");
		System.out.println(listOperations.range("mylist", 0, -1));//[d, c, b]

		Long size = listOperations.size("mylist");
		System.out.println(size);//3
	}

	/**
	 * 操作set类型的数据
	 */
	@Test
	public void testSet() {
		//sadd smembers scard sinter sunion srem
		SetOperations setOperations = redisTemplate.opsForSet();
		setOperations.add("set1", "a", "b", "c", "d");
		setOperations.add("set2", "a", "b", "x", "y");

		Set set1 = setOperations.members("set1");
		System.out.println(set1);//[d, c, a, b]

		Long size = setOperations.size("set1");
		System.out.println(size);//4

		Set intersection = setOperations.intersect("set1", "set2");
		System.out.println(intersection);//[a, b]

		Set union = setOperations.union("set1", "set2");
		System.out.println(union);//[c, a, b, d, x, y]

		setOperations.remove("set1", "a", "b");
		System.out.println(setOperations.members("set1"));//[d, c]
	}

	/**
	 * 操作zset类型的数据  有序集合
	 */
	@Test
	public void testZset() {
		//zadd zrange zincrby zrem
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		zSetOperations.add("zset", "a", 10);
		zSetOperations.add("zset", "b", 12);
		zSetOperations.add("zset", "c", 9);

		Set zset = zSetOperations.range("zset", 0, -1);
		System.out.println(zset);//[c, a, b]

		//将指定元素的score + delta
		zSetOperations.incrementScore("zset", "c", 10);
		Double score = zSetOperations.score("zset", "c");
		System.out.println(score);//19.0

		zSetOperations.remove("zset", "a", "b");
	}

	/**
	 * 通用命令操作
	 */
	@Test
	public void testCommon() {
		Set keys = redisTemplate.keys("*");
		System.out.println(keys);//[zset, set1, user:1, set2, lock, mylist, city]

		Boolean isName = redisTemplate.hasKey("name");
		Boolean isSet = redisTemplate.hasKey("set");

		//ZSET
		//SET
		//HASH
		//STRING
		//SET
		//STRING
		//LIST
		//STRING
		for (Object key : keys) {
			DataType type = redisTemplate.type(key);
			System.out.println(type.name());
		}

		redisTemplate.opsForList().leftPush("testdel", "a");
		redisTemplate.delete("testdel");
	}
}
