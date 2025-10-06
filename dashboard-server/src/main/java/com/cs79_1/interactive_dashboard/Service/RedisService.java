package com.cs79_1.interactive_dashboard.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final ObjectMapper objectMapper;

    public RedisService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public <T> void saveObject(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> T getObject(String key, Class<T> clazz) {
        Object object = redisTemplate.opsForValue().get(key);
        if (object == null) {
            return null;
        }

        return objectMapper.convertValue(object, clazz);
    }

    public <T> List<T> getList(String key, Class<T> elementClass) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return null;
        }

        JavaType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, elementClass);
        return objectMapper.convertValue(value, listType);
    }

    public <T> void saveWithExpire(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public void saveHash(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public void saveList(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    public void saveSet(String key, Object... values) {
        redisTemplate.opsForSet().add(key, values);
    }
}
