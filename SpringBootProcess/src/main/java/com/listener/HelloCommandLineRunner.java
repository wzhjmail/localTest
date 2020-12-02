package com.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName HelloCommandLineRunner
 * @Description
 * @Author wzj
 * @Date 2020/11/13 14:26
 **/
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner...run..." + Arrays.asList(args));
    }
}
