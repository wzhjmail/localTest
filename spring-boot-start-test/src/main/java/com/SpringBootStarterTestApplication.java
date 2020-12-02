package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName SpringBootStarterTestApplication
 * @Description
 * @Author wzj
 * @Date 2020/11/13 16:13
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootStarterTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterTestApplication.class, args);
    }
}
