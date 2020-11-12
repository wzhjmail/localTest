package com.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.*;

/**
 * WebMvcConfigurer: 自定义一些Handler，Interceptor，ViewResolver，MessageConverter
 */

@EnableWebMvc
@ComponentScan(basePackages = {"com.controller"})
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] paths = StringUtils.tokenizeToStringArray("/",",");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(paths);

        // 可以添加 HandlerMethodArgumentResolver 实现在controller中获取当前用户的信息！
    }

}
