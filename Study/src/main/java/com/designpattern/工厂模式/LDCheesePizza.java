package com.designpattern.工厂模式;

/**
 * @ClassName LDCheesePizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 19:58
 **/

public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的奶酪披萨");
        System.out.println("伦敦的奶酪披萨 准备原材料");
    }
}
