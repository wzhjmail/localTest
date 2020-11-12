package com.entity;

import com.common.checkparameter.StringNotNull;
import lombok.Data;

/**
 * @ClassName Fruit
 * @Description
 * @Author wzj
 * @Date 2020/8/5 14:52
 **/
@Data
public class Fruit {
    @StringNotNull("fruit name not null")
    private String name;
}
