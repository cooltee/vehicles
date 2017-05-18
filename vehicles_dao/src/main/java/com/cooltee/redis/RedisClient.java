package com.cooltee.redis;

import com.cooltee.redis.serializer.RedisSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;

import java.util.*;


/**
 * Utilize class of Redis Client
 * Created by Daniel on 2017/5/17.
 */
public class RedisClient {

    private static Logger log = LogManager.getLogger(RedisClient.class);

    private static RedisSerializer<String> keyRedisSerializer;
    private static RedisSerializer<Object> valueRedisSerializer;
    private static JedisPool jedisPool = null;

    /**
     * set static field using spring bean factory config
     */
    public static void staticSetter(JedisPool jedisPool, RedisSerializer<String> keyRedisSerializer, RedisSerializer<Object> valueRedisSerializer) {
        RedisClient.jedisPool = jedisPool;
        RedisClient.keyRedisSerializer = keyRedisSerializer;
        RedisClient.valueRedisSerializer = valueRedisSerializer;
    }

    /**
     *  the jedisPool
     */
    public static JedisPool getJedisPool() {
        return jedisPool;
    }


    /**
     *  Key序列化
     */
    private static byte[] keyRedisSerializer(String key) throws Exception {
        return keyRedisSerializer.serialize(key);
    }

    /**
     *  Key反序列化
     */
    private static String keyRedisDeserializer(byte[] key) throws Exception {
        return keyRedisSerializer.deserialize(key);
    }

    /**
     *  value序列化
     */
    private static byte[] valueRedisSerializer(Object value) throws Exception {
        return valueRedisSerializer.serialize(value);
    }

    /**
     *  value反序列化
     */
    private static Object valueRedisDeserializer(byte[] value) throws Exception {
        if (null != value) {
            return valueRedisSerializer.deserialize(value);
        } else {
            return null;
        }
    }

    private static Map<byte[], byte[]> byteMapConvertFromObject(Map<String, Object> hash) throws Exception {
        Map<byte[], byte[]> bHash = new HashMap<>(hash.size());
        for (Map.Entry<String, Object> entry : hash.entrySet()) {
            bHash.put(keyRedisSerializer(entry.getKey()), valueRedisSerializer(entry.getValue()));
        }
        return bHash;
    }

    private static Map<String, Object> objectMapConvertFromByte(Map<byte[], byte[]> map) throws Exception {
        Map<String, Object> newMap = new HashMap<>(map.size());
        for (Map.Entry<byte[], byte[]> entry : map.entrySet()) {
            newMap.put(keyRedisDeserializer(entry.getKey()), valueRedisDeserializer(entry.getValue()));
        }
        return newMap;
    }

    private static List<Object> objectListConvertFromByte(List<byte[]> list) throws Exception {
        List<Object> newlist = new ArrayList<>();
        for (byte[] record : list) {
            newlist.add(valueRedisDeserializer(record));
        }
        return newlist;
    }

    private static Set<Object> objectSetConvertFromByte(Set<byte[]> set) throws Exception {
        Set<Object> result = new HashSet<>(set.size());
        for (byte[] record : set) {
            if (record == null) {
                result.add(null);
            } else {
                result.add(valueRedisDeserializer(record));
            }
        }
        return result;
    }

    /**
     *
     *  set
     *  设置键值     注：使用set方法添加的数字类型数据，不可以使用自增或自减 
     */
    public static String set(String key, Object value) {
        String result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.set(keyRedisSerializer(key), valueRedisSerializer(value));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  setex
     *  设置生存时间
     *
     */
    public static String setex(String key, int seconds, Object value) {
        String result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.setex(keyRedisSerializer(key), seconds, valueRedisSerializer(value));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  获取单个值（该方法不可用于获取自增或自减操作的值）
     */
    public static Object get(String key) {
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = valueRedisDeserializer(jedis.get(keyRedisSerializer(key)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  getIncrAndDecrValue
     *  获取自增或自减操作的值，该方法获取的值无需序列化
     */
    public static Object getIncrAndDecrValue(String key) {
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  exists
     *  判断指定key是否存在
     */
    public static Boolean exists(String key) {
        Boolean result = false;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return false;
        }
        try {
            result = jedis.exists(keyRedisSerializer(key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  expire
     *   为给定 key 设置生存时间
     */
    public static Long expire(String key, int seconds) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.expire(keyRedisSerializer(key), seconds);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  expireAt
     *  在某个时间点失效
     */
    public static Long expireAt(String key, long unixTime) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.expireAt(keyRedisSerializer(key), unixTime);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  getSet
     *  获取一个set
     */
    public static Object getSet(String key, Object value) {
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = valueRedisDeserializer(jedis.getSet(keyRedisSerializer(key), valueRedisSerializer(value)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  对指定key进行自减操作，每次减少指定数值，对不存在的key，自动创建并减指定数值
     */
    public static Long decrBy(String key, long integer) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.decrBy(keyRedisSerializer(key), integer);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  对指定key进行自减操作，每次减少1，对不存在的key，自动创建并减1
     */
    public static Long decr(String key) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.decr(keyRedisSerializer(key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  对指定key进行自增操作，每次增加指定数值，对不存在的key，自动创建并加指定数值
     */
    public static Long incrBy(String key, long integer) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.incrBy(keyRedisSerializer(key), integer);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  对指定key进行自增操作，每次增加1，对不存在的key，自动创建并加1
     */
    public static Long incr(String key) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.incr(keyRedisSerializer(key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  将哈希表 key 中的域 field 的值设为 value
     */
    public static Long hset(String key, String field, Object value) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.hset(keyRedisSerializer(key), keyRedisSerializer(field), valueRedisSerializer(value));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  返回哈希表 key 中给定域 field 的值
     */
    public static Object hget(String key, String field) {
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = valueRedisDeserializer(jedis.hget(keyRedisSerializer(key), keyRedisSerializer(field)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *
     *  同时将多个 field-value (域-值)对设置到哈希表 key 中
     *
     */
    public static String hmset(String key, Map<String, Object> hash) {
        String result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.hmset(keyRedisSerializer(key), byteMapConvertFromObject(hash));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  返回哈希表 key 中，一个或多个给定域的值
     */
    public static List<Object> hmget(String key, String... fields) {
        List<Object> result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            byte[][] bfields = new byte[fields.length][];
            for (int i = 0; i < bfields.length; i++) {
                bfields[i] = keyRedisSerializer(fields[i]);
            }
            result = objectListConvertFromByte(jedis.hmget(keyRedisSerializer(key), bfields));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public static Long hincrBy(String key, String field, long value) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.hincrBy(keyRedisSerializer(key), keyRedisSerializer(field), value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  删除给定的一个或多个 key
     */
    public static Long del(String key) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.del(keyRedisSerializer(key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  根据key前缀批量删除
     */
    public static Long delByPrefix(String pre_str) {
        Long result = 0L;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return result;
        }
        StringBuilder keys = new StringBuilder();
        try {
            Set<String> set = jedis.keys(pre_str + "*");
            for (String keyStr : set) {
                result = result + del(keyStr);
                keys.append(keyStr).append("; ");
            }
            log.info("delByPrefix keys is " + keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略
     */
    public static Long hdel(String key, String field) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.hdel(keyRedisSerializer(key), keyRedisSerializer(field));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  返回哈希表 key 中所有域的值
     */
    public static List<Object> hvals(String key) {
        List<Object> result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = objectListConvertFromByte(jedis.hvals(keyRedisSerializer(key)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  返回哈希表 key 中，所有的域和值
     */
    public static Map<String, Object> hgetAll(String key) {
        Map<String, Object> result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = objectMapConvertFromByte(jedis.hgetAll(keyRedisSerializer(key)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  将一个或多个值 value 插入到列表 key 的表尾(最右边)
     */
    public static Long rpush(String key, Object value) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.rpush(keyRedisSerializer(key), valueRedisSerializer(value));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  将一个或多个值 value 插入到列表 key 的表头
     */
    public static Long lpush(String key, Object value) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.lpush(keyRedisSerializer(key), valueRedisSerializer(value));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public static Long llen(String key) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.llen(keyRedisSerializer(key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略
     */
    public static Long sadd(String key, Object value) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.sadd(keyRedisSerializer(key), valueRedisSerializer(value));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  批量添加元素
     */
    public static Long saddBatch(String key, Object... values) {
        Long result = 0L;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return result;
        }
        try {
            for (Object value : values) {
                jedis.sadd(keyRedisSerializer(key), valueRedisSerializer(value));
                result++;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  返回集合 key 中的所有成员
     */
    public static Set<Object> smembers(String key) {
        Set<Object> result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = objectSetConvertFromByte(jedis.smembers(keyRedisSerializer(key)));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  返回集合 key 的基数(集合中元素的数量)
     */
    public static Long scard(String key) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.scard(keyRedisSerializer(key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  为有序集 key 的成员 member 的 score 值加上增量 increment
     */
    public static Double zincrby(String key, double score, Object value) {
        Double result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.zincrby(keyRedisSerializer(key), score, valueRedisSerializer(value));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  返回有序集 key 的基数
     */
    public static Long zcard(String key) {
        Long result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.zcard(keyRedisSerializer(key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public static Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        Set<Tuple> result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.zrangeByScoreWithScores(keyRedisSerializer(key), min, max, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     */
    public static Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        Set<Tuple> result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.zrevrangeByScoreWithScores(keyRedisSerializer(key), max, min, offset, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     *  事务操作Transaction 调用该方法外层需要序列化数据
     */
    public static Transaction multi() {
        Transaction result = null;
        Jedis jedis = jedisPool.getResource();
        if (jedis == null) {
            return null;
        }
        try {
            result = jedis.multi();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return result;
    }

}
