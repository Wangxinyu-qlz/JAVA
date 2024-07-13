package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-13 10:21
 * @description:
 **/
@Configuration
@Slf4j
public class RedisConfiguration {
	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
		log.info("开始初始化redisTemplate对象");
		RedisTemplate redisTemplate = new RedisTemplate();
		//设置连接工厂对象
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		//设置redis序列化器
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}
