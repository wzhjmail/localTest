package com.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName HelloApplicationContextInitiializer
 * @Description
 * @Author wzj
 * @Date 2020/11/13 14:10
 **/

public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializer...initialize..." + configurableApplicationContext);
    }
}
