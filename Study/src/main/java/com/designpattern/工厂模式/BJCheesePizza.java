package com.designpattern.工厂模式;

/**
 * @ClassName BJCheesePizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 19:48
 **/

public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京的奶酪披萨");
    System.out.println("北京的奶酪披萨 准备原材料");
    }
}
