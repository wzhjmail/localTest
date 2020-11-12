package com.designpattern.策略模式;

/**
 * @ClassName WildDuck
 * @Description
 * @Author wzj
 * @Date 2020/10/9 16:49
 **/

public class WildDuck extends Duck {

    public WildDuck(){
        flyBehavior = new GoodFlyBehavior();
    }
    @Override
    public void display() {
    System.out.println("这是野鸭");
    }
}
