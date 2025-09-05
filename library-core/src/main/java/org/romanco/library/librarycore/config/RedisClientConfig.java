package org.romanco.library.librarycore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisClientConfig {

    @Bean
    public Jedis jedisClient() {
        Jedis jedis = new Jedis("localhost", 6379);
//        jedis.auth("123");
        return jedis;
    }
}
