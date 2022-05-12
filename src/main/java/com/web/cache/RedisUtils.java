package com.web.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisUtils {

    // key - object
    private RedisTemplate<String, Object> redisTemplate;
    // key - string
    private StringRedisTemplate stringRedisTemplate;

    // 初始化构建
    public RedisUtils(RedisTemplate<String, Object> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    // STRING OPERATE
    /**
     * set通用key - value 默认不设置超时时间
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        set(key, value, -1);
    }

    /**
     * set通用key - value 需要指定超时时间
     * @param key
     * @param value
     * @param time
     */
    public void set(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value);
        if (time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * 获取通用Object 根据业务向下转型
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getObject(String key) {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        return (T) valueOps.get(key);
    }

    /**
     * set String类型 key - value 需要指定超时时间
     * @param key
     * @param value
     * @param time
     */
    public void setStr(String key, String value, long time) {
        stringRedisTemplate.opsForValue().set(key, value);
        if (time > 0) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * set String类型 key - value 默认不设置超时时间
     * @param key
     * @param value
     */
    public void setStr(String key, String value) {
        setStr(key, value, -1);
    }

    /**
     * 获取 String类型的value
     * @param key
     * @return
     */
    public String getStr(String key) {
        return  stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 判断Key是否存在
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据Key删除元素
     * @param key
     */
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 根据Key获取超时时间
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 获取匹配的Key集合
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 原子性递增
     * @param key
     * @param delta
     * @return
     */
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 原子性递减
     * @param key
     * @param delta
     * @return
     */
    public Double increment(String key, double delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    // SET OPERATE

    /**
     * 根据key获取Set集合
     * @param key
     * @return
     */
    public Set<Object> setGet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 根据value在set中是否存在
     * @param key
     * @param value
     * @return
     */
    public boolean setHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 将数据放入set缓存
     * @param key
     * @param value
     * @return
     */
    public long setAdd(String key, Object value) {
        return redisTemplate.opsForSet().add(key, value);
    }

    /**
     * 将set数据放入缓存
     * @param key
     * @param time
     * @param value
     * @return
     */
    public long setAdd(String key, Object value, long time) {
        Long count = redisTemplate.opsForSet().add(key, value);
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
        return count;
    }

    /**
     * 获取set缓存的长度
     * @param key
     * @return
     */
    public long setGetSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 移除Set 值value
     * @param key
     * @param value
     * @return
     */
    public long setRemove(String key, Object value) {
        return redisTemplate.opsForSet().remove(key, value);
    }

}