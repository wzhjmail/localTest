package com.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestAnnController
 * @Description
 * @Author wzj
 * @Date 2021/5/11 15:36
 **/

@RestController
public class TestAnnController {

    //定义资源 value:设置资源的名称 blockHandler:设置限流或降级的处理函数
    @SentinelResource(value = "Sentinel_Ann", blockHandler = "exceptionHandler")
    @GetMapping("ann")
    public String helloAnn() {
        //使用限流规则
        return "hello sentinel";
    }

    //被限流或降级的处理函数
    public String exceptionHandler(BlockException e) {
        e.printStackTrace();
        return "系统繁忙，请稍后！";
    }

}
