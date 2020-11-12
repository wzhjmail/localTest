package com.designpattern.装饰者模式;

/**
 * @ClassName Chocolate
 * @Description
 * @Author wzj
 * @Date 2020/10/16 14:55
 **/
//具体的Decorator ,这里就是调味品
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDesc(" 巧克力 ");
        setPrice(3.0f);//调味品的价格
    }
}
