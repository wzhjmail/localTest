package com.designpattern.策略模式;

/**
 * @ClassName ToyDuck
 * @Description
 * @Author wzj
 * @Date 2020/10/9 16:53
 **/

public class ToyDuck extends Duck {

    public ToyDuck(){
        flyBehavior = new NoFlyBehavior();
    }
    @Override
    public void display() {
    System.out.println("玩具鸭");
    }

    public void quack(){
    System.out.println("玩具鸭不能叫");
    }

    public void swim() {
    System.out.println("玩具鸭不会游泳");
    }
}
