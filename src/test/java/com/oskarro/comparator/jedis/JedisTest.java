package com.oskarro.comparator.jedis;

import com.oskarro.comparator.common.JedisCommon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class JedisTest {

    @Autowired
    JedisCommon jedis;

    @Test
    void shouldAddRecordToRedis() {
        // GIVEN
        String key = "test:item:item1";
        String value = "costValue";

        // WHEN
        String cachedResponse = jedis.set(key, value);
        System.out.println(cachedResponse);

        // THEN
        assertThat(jedis.get(key)).isNotNull();
    }

    // Redis Lists are simply lists of strings, sorted by insertion order
    @Test
    void shouldAddValueToListAndSortByInsertionOrder() {
        // GIVEN
        String listKey = "queue#tasks";
        String firstItem = "firstItem";
        String secondItem = "secondItem";

        // WHEN
        jedis.lpush(listKey, firstItem);
        jedis.lpush(listKey, secondItem);

        // THEN
        assertThat(jedis.rpop(listKey)).isEqualTo(firstItem);
        assertThat(jedis.get(listKey)).isNotNull();
        assertThat(jedis.rpop(listKey)).isEqualTo(secondItem);
    }
}
