package com.qlz.springdataredisdemo.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @program: springData-redis-demo
 * @author: Qiaolezi
 * @create: 2024-06-21 15:38
 * @description:
 **/
/**
 * Redis配置类
 * 用于配置Redis模板及其相关序列化器
 */
@Configuration
public class RedisConfig {

    /**
     * 创建并配置Redis模板
     *
     * @param connectionFactory Redis连接工厂，用于创建Redis连接
     * @return 配置好的Redis模板，用于操作Redis数据库
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 设置连接工厂
        template.setConnectionFactory(connectionFactory);

        // 使用Jackson2JsonRedisSerializer作为值的序列化器，支持将Java对象序列化为JSON格式存储
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        // 配置键的序列化器为StringRedisSerializer
        template.setKeySerializer(RedisSerializer.string());
        // 配置哈希键的序列化器为StringRedisSerializer
        template.setHashKeySerializer(RedisSerializer.string());

        //TODO JSON序列化器会将class信息一并存储
        //{\"@class\":\"com.qlz.springdataredisdemo.redis.config.pojo.User\",\"name\":\"qlz\",\"age\":12}
        //为了节省空间，会使用String序列化器，只存储key value
        //存储java对象时，手动完成对象的序列化和反序列化

        // 配置值的序列化器为Jackson2JsonRedisSerializer
        template.setValueSerializer(jsonRedisSerializer);
        // 配置哈希值的序列化器为Jackson2JsonRedisSerializer
        template.setHashValueSerializer(jsonRedisSerializer);

        return template;
    }
}

