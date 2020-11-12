package com.designpattern.装饰者模式;

/**
 * @ClassName Milk
 * @Description
 * @Author wzj
 * @Date 2020/10/16 14:58
 **/

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDesc("牛奶");
        setPrice(2.0f);
    }
}
