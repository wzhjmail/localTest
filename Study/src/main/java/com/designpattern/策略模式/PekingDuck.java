package com.designpattern.策略模式;

/**
 * @ClassName PekingDuck
 * @Description
 * @Author wzj
 * @Date 2020/10/9 16:52
 **/

public class PekingDuck extends Duck {

    public PekingDuck(){
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
    System.out.println("北京鸭");
    }


}
