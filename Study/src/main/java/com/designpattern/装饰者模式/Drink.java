package com.designpattern.装饰者模式;

import lombok.Data;

/**
 * @ClassName Drink
 * @Description
 * @Author wzj
 * @Date 2020/10/16 14:39
 **/
@Data
public abstract class Drink {

    public String desc;//描述

    private float price = 0.0f;

    //计算费用的抽象方法
    //子类来实现
    public abstract float cost();
}
