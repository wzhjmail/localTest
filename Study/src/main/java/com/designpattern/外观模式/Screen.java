package com.designpattern.外观模式;

/**
 * @ClassName Screen
 * @Description
 * @Author wzj
 * @Date 2020/8/7 11:33
 **/

public class Screen {
    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void up() {
        System.out.println("Screen up  ");
    }
    public void down() {
        System.out.println("Screen down  ");
    }

}
