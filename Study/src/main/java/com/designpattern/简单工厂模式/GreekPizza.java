package com.designpattern.简单工厂模式;

/**
 * @ClassName GreekPizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 10:30
 **/

public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
    System.out.println("希纳披萨，准备原材料");
    }
}
