package com.hmdp.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: hm-dianping
 * @author: Qiaolezi
 * @create: 2024-07-01 12:03
 * @description: 使用redisson ，主要是用分布式锁
 **/
@Configuration
public class RedissonConfig {
	@Bean
	public RedissonClient redissonClient() {
		Config config = new Config();
		//添加redis地址，单点，集群使用config.useClusterServers()添加集群地址
		config.useSingleServer().setAddress("redis://192.168.10.128").setPassword("123456");
		//创建客户端
		return Redisson.create(config);
	}
}
