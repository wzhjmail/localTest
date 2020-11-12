package com.designpattern.策略模式;

/**
 * @ClassName BadFlyBehavior
 * @Description
 * @Author wzj
 * @Date 2020/10/9 16:44
 **/

public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
    System.out.println("飞翔技术一般～～～");
    }
}
