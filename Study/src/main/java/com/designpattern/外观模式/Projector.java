package com.designpattern.外观模式;

/**
 * @ClassName Projector
 * @Description
 * @Author wzj
 * @Date 2020/8/7 11:31
 **/

public class Projector {
    private static Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("projector on  ");
    }
    public void off() {
        System.out.println("projector off  ");
    }
    public void focus() {
        System.out.println("projector is focus  ");
    }
}
