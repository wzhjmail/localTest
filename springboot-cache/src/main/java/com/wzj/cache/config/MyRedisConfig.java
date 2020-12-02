package com.wzj.cache.config;

import com.wzj.cache.bean.Department;
import com.wzj.cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.net.UnknownHostException;

/**
 * @ClassName MyRedisConfig
 * @Description
 * @Author wzj
 * @Date 2020/11/24 18:58
 **/
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Employee>(Employee.class));
        return template;
    }

    @Bean
    public RedisTemplate<Object, Department> depRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Department>(Department.class));
        return template;
    }

    @Bean
    @Primary
    //将某个缓存管理器作为默认的
    public RedisCacheManager empCacheManager(RedisTemplate<Object, Department> empRedisTemplate) {

        //传入上面模版对象的连接工厂， 内部也是为其设置连接工厂和sleeptime
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(empRedisTemplate.getConnectionFactory());

        //在redis缓存配置文件中传入刚定义好的缓存配置mpRedisTemplate.getValueSerializer()
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(empRedisTemplate.getValueSerializer()));

        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
