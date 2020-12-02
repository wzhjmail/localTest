package com.wzj.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @ClassName MyKeyGenerator
 * @Description
 * @Author wzj
 * @Date 2020/11/23 17:45
 **/

@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... params) {
                return method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

}
