package com.aop;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AOPController
 * @Description
 * @Author wzj
 * @Date 2020/8/6 10:56
 **/
@RestController
@RequestMapping("/aop")
public class AOPController {

    @RequestMapping("/aroundTest")
    //@Action(name="123")
    public List<String> aroundTest(@RequestBody List<String> name) {//List<String>
        System.out.println(name);
        return name;
    }
}
