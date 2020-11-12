package com.proxy.statics;

/**
 * @ClassName BuyCarProxy
 * @Description
 * @Author wzj
 * @Date 2020/8/5 15:18
 **/

public class BuyCarProxy implements BuyCar {
    private BuyCar buyCar;

    public BuyCarProxy(final BuyCar buyCar) {
        this.buyCar = buyCar;
    }

    public void buyCar() {
        System.out.println("买车前准备");
        buyCar.buyCar();
        System.out.println("买车后保养");
    }

}