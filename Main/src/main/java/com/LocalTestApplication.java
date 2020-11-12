package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {ConfigBeanValue.class}))
@SpringBootApplication
@MapperScan("com.dao")
@ImportResource({"classpath:*.xml"})
public class LocalTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocalTestApplication.class, args);
    }
}
