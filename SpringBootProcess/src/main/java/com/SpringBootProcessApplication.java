package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName SpringBootProcessApplication
 * @Description
 * @Author wzj
 * @Date 2020/11/12 14:59
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootProcessApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProcessApplication.class, args);
    }
}
