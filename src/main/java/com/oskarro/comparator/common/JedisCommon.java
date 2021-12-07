package com.oskarro.comparator.common;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisCommon {

    private final JedisPool jedisPool;

    public JedisCommon(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * Store string key value pairs, permanently valid
     * @param key
     * @param value
     * @author hw
     * @date 2021 07 December
     */
    public String set(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.set(key, value);
        } catch (Exception e) {
            return "-1";
        }
        // The business operation is completed and the connection is returned to the connection pool
    }

    /**
     * Get the specified Value according to the passed in key
     * @param key
     * @author hw
     * @date 2021 07 December
     */
    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        } catch (Exception e) {
            return "-1";
        }
    }

    /**
     * Delete string key value pairs
     * @param key
     * @author hw
     * @date 2021 07 December
     */
    public Long delete(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(key);
        } catch (Exception e) {
            return -1L;
        }
    }
    /**
     * Verify whether the Key value exists
     * @param key
     * @author hw
     * @date 2021 07 December
     */
    public Boolean exists(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(key);
        } catch (Exception e) {
            return false;
        }
        // Return connection
    }
}
