package com.cooltee.redis.serializer;

import org.springframework.stereotype.Component;

import java.io.*;

/**
 * the Implements of Redis Serializer
 * 
 * Use the JDK serialization mechanism, the <code>POJO</code> class will be serialized by
 * <code>ObjectInputStream</code>/<code>ObjectOutputStream</code>.
 *
 * Created by Daniel on 2017/5/17.
 */
@Component("valueRedisSerializer")
public class JdkSerializationRedisSerializer implements RedisSerializer<Object> {

    private byte[] convert(Object source) throws Exception {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(1024);
        try {
            serialize(source, byteStream);
            return byteStream.toByteArray();
        } catch (Exception ex) {
            throw new Exception("Failed to serialize object using JdkSerializationRedisSerializer", ex);
        }
    }

    private void serialize(Object object, OutputStream outputStream) throws IOException {
        if (!(object instanceof Serializable)) {
            throw new IllegalArgumentException(
                    getClass().getSimpleName() + " requires a Serializable payload but received an object of type ["
                            + object.getClass().getName() + "]");
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
    }

    private Object convert(byte[] source) throws Exception {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(source);
        try {
            return deserialize(byteStream);
        } catch (Exception ex) {
            throw new Exception(
                    "Failed to deserialize payload. Is the byte array a result of corresponding serialization for JdkSerializationRedisSerializer",
                    ex);
        }
    }

    private Object deserialize(InputStream inputStream) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            return objectInputStream.readObject();
        } catch (Exception ex) {
            throw new Exception("Failed to deserialize object type", ex);
        }
    }

    public Object deserialize(byte[] bytes) throws Exception {
        try {
            return convert(bytes);
        } catch (Exception ex) {
            throw new Exception("Cannot deserialize", ex);
        }
    }

    public byte[] serialize(Object object) throws Exception {
        try {
            return convert(object);
        } catch (Exception ex) {
            throw new Exception("Cannot serialize", ex);
        }
    }

}
