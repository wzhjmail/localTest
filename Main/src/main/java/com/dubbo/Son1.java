package com.dubbo;

import lombok.Data;

/**
 * @ClassName Son1
 * @Description
 * @Author wzj
 * @Date 2020/8/21 13:53
 **/
@Data
public class Son1 extends Par {
    private String name1;
    private Son2 son2;
    private Integer age;
}
