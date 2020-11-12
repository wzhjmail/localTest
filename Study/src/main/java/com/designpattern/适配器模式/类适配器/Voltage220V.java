package com.designpattern.适配器模式.类适配器;

/**
 * @ClassName Voltage220V
 * @Description
 * @Author wzj
 * @Date 2020/10/15 15:36
 **/

public class Voltage220V {

    public int output220V() {
        int src = 220;
    System.out.println("电压=" + src +"伏");
    return src;
    }
}
