package com.common.checkparameter.test;

import com.common.checkparameter.ParameterRequired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ParameterAnnotationTest
 * @Description
 * @Author wzj
 * @Date 2020/9/14 14:36
 **/

@RequestMapping("/anno")
@Controller
public class ParameterAnnotationTest {

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestBody CreateContract createContract) {

        new ParameterRequired(createContract).validate();

        return createContract.toString();

    }
}
