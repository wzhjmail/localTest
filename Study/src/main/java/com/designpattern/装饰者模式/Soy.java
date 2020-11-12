package com.designpattern.装饰者模式;

/**
 * @ClassName Soy
 * @Description
 * @Author wzj
 * @Date 2020/10/16 14:59
 **/

public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDesc(" 豆浆 ");
        setPrice(1.5f);
    }
}
