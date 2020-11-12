package com.designpattern.外观模式;

/**
 * @ClassName PopCorn
 * @Description
 * @Author wzj
 * @Date 2020/8/7 11:27
 **/

public class PopCorn {
    private static PopCorn instance = new PopCorn();

    public static PopCorn getInstance(){
        return instance;
    }

    public void on(){
    System.out.println("popcorn on");
    }

    public void off(){
        System.out.println("popcorn off");
    }

    public void pop(){
        System.out.println("popcorn is poping");
    }
}
