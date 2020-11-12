package com.designpattern.外观模式;

/**
 * @ClassName TheaterLight
 * @Description
 * @Author wzj
 * @Date 2020/8/7 11:36
 **/

public class TheaterLight {
    private static TheaterLight instance = new TheaterLight();

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("TheaterLight on  ");
    }
    public void off() {
        System.out.println("TheaterLight off  ");
    }
    public void dim() {
        System.out.println("TheaterLight dim...  ");
    }
    public void bright() {
        System.out.println("TheaterLight is bright  ");
    }
}
