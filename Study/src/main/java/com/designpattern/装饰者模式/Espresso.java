package com.designpattern.装饰者模式;

/**
 * @ClassName Espresso
 * @Description
 * @Author wzj
 * @Date 2020/10/16 14:42
 **/
//蒸馏咖啡
public class Espresso extends Coffee {

    public Espresso() {
        setDesc("意大利咖啡");
        setPrice(6.0f);
    }
}
