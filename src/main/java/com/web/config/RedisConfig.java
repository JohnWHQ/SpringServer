// Copyright 2018 Baidu Inc BDG. All rights reserved.

package com.web.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.cache.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 *
 * redis相关配置
 *
 * @author  John Wang
 *
 */

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 获取原生RedisTemplate对象
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置原生工厂类
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 替换默认JDK序列化 使用Jackson2JsonRedisSerialize
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等抛异常
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        // 利用Jackson2JsonRedisSerialize序列化
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 设置key的序列化规则
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

        // 设置hash key 和value序列化模式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setKeySerializer(stringSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisUtils redisUtil(RedisTemplate<String, Object> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        RedisUtils redisUtil = new RedisUtils(redisTemplate, stringRedisTemplate);
        return redisUtil;
    }
}
