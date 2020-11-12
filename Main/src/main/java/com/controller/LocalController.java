package com.controller;

import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RequestMapping("/local")
@Controller
@EnableAsync
public class LocalController {
//    @Autowired
//    private JedisCluster jedis;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/test")
    @ResponseBody
    //@Action(name="注解式拦截-----")
    public String test(@RequestBody String name) {
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate
//                .opsForValue()
//                .set("12306", "6", 1, TimeUnit.SECONDS);
        //jedis.psetex("12306", 30000L, "1");
        return "test777----"+name;
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
        String path = "/tmp/"+file.getOriginalFilename();
        File dest = new File(path);
        file.transferTo(dest);

        return path;
    }

    @RequestMapping("/async")
    @ResponseBody
    public void async() throws Exception{
            studentService.asyncMethod(1);
            studentService.asyncMethod(2);

    }

}
