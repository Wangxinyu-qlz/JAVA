package com.qlz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App {
    private Jedis jedis = null;
    @BeforeEach
    public void init() {
        jedis = new Jedis("192.168.10.128", 6379);
        jedis.auth("123456");
        jedis.select(0);
    }

    @Test
    public void test() {
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));
        System.out.println(jedis.get("class"));
        System.out.println(jedis.get("money"));
        String result = jedis.mset("name", "qlz", "age", "18", "class", "1", "money", "100");
        System.out.println("result:" + result);
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));
        System.out.println(jedis.get("class"));
        System.out.println(jedis.get("money"));
    }

    @AfterEach
    public void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
