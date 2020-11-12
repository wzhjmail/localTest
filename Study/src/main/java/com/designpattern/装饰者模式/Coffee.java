package com.designpattern.装饰者模式;

/**
 * @ClassName Coffee
 * @Description
 * @Author wzj
 * @Date 2020/10/16 14:41
 **/

public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
