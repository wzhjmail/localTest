package com.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloApplicationRunner
 * @Description
 * @Author wzj
 * @Date 2020/11/13 14:22
 **/
@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner...run...");
    }
}
