package com.isle.preventrepeat.handler.impl;

import com.isle.preventrepeat.handler.PreventRepeatHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisPreventRepeatHandler implements PreventRepeatHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisPreventRepeatHandler.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${preventRepeat.timeout:60000}")
    private Long timeout;

    @Override
    public boolean setIfAbsent(String prefix, String key) {
        //忽略大小写
        String redisKey = (prefix + key).toUpperCase();
        try {
            return redisTemplate.opsForValue().setIfAbsent(redisKey, key, timeout, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            LOGGER.error("set redis key error, redisKey = {}", redisKey, e);
            return true;
        }

    }

    @Override
    public void delete(String prefix, String key) {
        String redisKey = (prefix + key).toUpperCase();
        redisTemplate.delete(redisKey);
    }
}
