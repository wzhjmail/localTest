package com.designpattern.外观模式;

/**
 * @ClassName Stereo
 * @Description
 * @Author wzj
 * @Date 2020/8/7 11:34
 **/

public class Stereo {
    private static Stereo instance = new Stereo();

    public static Stereo getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("Stereo on  ");
    }
    public void off() {
        System.out.println("Stereo off  ");
    }
    public void up() {
        System.out.println("Stereo up...  ");
    }

}
