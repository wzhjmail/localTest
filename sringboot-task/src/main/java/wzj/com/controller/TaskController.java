package wzj.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wzj.com.service.AsyncService;

/**
 * @ClassName TaskController
 * @Description
 * @Author wzj
 * @Date 2020/12/15 19:06
 **/

@RestController
public class TaskController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        asyncService.sayHello();
        return "success";
    }
}
