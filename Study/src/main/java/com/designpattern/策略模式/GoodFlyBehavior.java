package com.designpattern.策略模式;

/**
 * @ClassName GoodFlyBehavior
 * @Description
 * @Author wzj
 * @Date 2020/10/9 16:43
 **/

public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
    System.out.println("飞翔技术高超～～～～～～");
    }
}
