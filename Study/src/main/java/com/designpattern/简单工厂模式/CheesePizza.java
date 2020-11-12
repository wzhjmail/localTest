package com.designpattern.简单工厂模式;

/**
 * @ClassName cheesePizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 10:29
 **/

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
    System.out.println("奶酪披萨，准备原材料");
    }
}
