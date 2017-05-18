package com.cooltee.redis.serializer;

import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * the Implements of Redis Serializer
 * 
 * According to the specified <code>charset</code>(default:"UTF8") to encode String
 * using <code>new String(bytes, charset)</code> and <code>string.getBytes(charset)</code>.
 *
 * Created by Daniel on 2017/5/17.
 */
@Component("keyRedisSerializer")
public class StringRedisSerializer implements RedisSerializer<String> {

    private final Charset charset;

    public StringRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public StringRedisSerializer(Charset charset) {
        this.charset = charset;
    }

    public String deserialize(byte[] bytes) {
        return (bytes == null ? null : new String(bytes, charset));
    }

    public byte[] serialize(String string) {
        return string == null ? null : string.getBytes(charset);
    }

}
