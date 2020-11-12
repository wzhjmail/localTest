package com.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @ClassName RedisMessageListener
 * @Description 定义配置RedisListenerConfig实现监听Redis key过期时间
 * @Author wzj
 * @Date 2020/10/29 10:38
 **/
//@Configuration
public class RedisMessageListener {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;

    }
}
