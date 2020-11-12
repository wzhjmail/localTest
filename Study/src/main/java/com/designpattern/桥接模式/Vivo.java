package com.designpattern.桥接模式;

/**
 * @ClassName Vivo
 * @Description
 * @Author wzj
 * @Date 2020/10/16 13:48
 **/

public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("Vivo手机开机");
    }

    @Override
    public void close() {
        System.out.println("Vivo手机关机");
    }

    @Override
    public void call() {
        System.out.println("Vivo手机打电话");
    }
}
