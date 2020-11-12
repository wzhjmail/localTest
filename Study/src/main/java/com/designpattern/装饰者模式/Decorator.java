package com.designpattern.装饰者模式;

/**
 * @ClassName Decorator
 * @Description
 * @Author wzj
 * @Date 2020/10/16 14:51
 **/
//装饰者
public class Decorator extends Drink {

    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        //getPrice先拿到自己的价格
        return super.getPrice() + obj.cost();
    }

    public String getDesc() {
        return "自己的信息："+ desc + "   " +  getPrice() + " ；&& 被装饰者的信息：" + obj.getDesc();
    }
}
