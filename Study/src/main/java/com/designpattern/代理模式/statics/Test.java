package com.designpattern.代理模式.statics;

/**
 * @ClassName Test
 * @Description
 * @Author wzj
 * @Date 2020/8/5 16:23
 **/

public class Test {
    public static void main(String[] args) {

        BuyCar buyCar = new BuyCarImpl();
        BuyCarProxy buyCarProxy = new BuyCarProxy(buyCar);
        buyCarProxy.buyCar();
    }

}
