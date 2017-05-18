package com.cooltee.redis.serializer;

/**
 * the Interface of Redis Serializer
 * Created by Daniel on 2017/5/17.
 */
public interface RedisSerializer<T> {

    /**
     * 序列化方法
     */
    byte[] serialize(T t) throws Exception;

    /**
     * 反序列化方法
     */
    T deserialize(byte[] bytes) throws Exception;
}
