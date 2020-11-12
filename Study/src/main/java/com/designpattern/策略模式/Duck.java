package com.designpattern.策略模式;

/**
 * @ClassName Duck
 * @Description
 * @Author wzj
 * @Date 2020/10/9 16:45
 **/

public abstract class Duck {

    //属性，策略接口
    FlyBehavior flyBehavior;
    //其他属性：策略模式

    public Duck(){}

    public abstract void display();//显示鸭子信息

    public void quack(){
    System.out.println("鸭子嘎嘎叫");
    }

    public void swim() {
    System.out.println("鸭子会游泳");
    }

    public void fly() {
    if(flyBehavior!=null){
        flyBehavior.fly();
    }
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
