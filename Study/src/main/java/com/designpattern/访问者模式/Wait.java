package com.designpattern.访问者模式;

/**
 * @ClassName Wait
 * @Description
 * @Author wzj
 * @Date 2020/8/7 14:56
 **/

public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
    System.out.println("男人给的结果时待定---");
    }

    @Override
    public void getWomanResult(Woman man) {
        System.out.println("女人给的结果时待定---");
    }
}
