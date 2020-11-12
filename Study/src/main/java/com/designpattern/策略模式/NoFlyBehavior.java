package com.designpattern.策略模式;

/**
 * @ClassName NoFlyBehavior
 * @Description
 * @Author wzj
 * @Date 2020/10/9 16:44
 **/

public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
    System.out.println("不会飞～～～");
    }
}
