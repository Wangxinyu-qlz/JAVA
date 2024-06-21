package com.qlz;

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
        jedis.select(0);
    }

    @Test
    public void test() {
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));
        System.out.println(jedis.get("class"));
        System.out.println(jedis.get("money"));
    }
}
