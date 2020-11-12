package com.designpattern.工厂模式;

/**
 * @ClassName BJPeeperPizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 19:57
 **/

public class BJPeeperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的胡椒披萨");
        System.out.println("北京的胡椒披萨 准备原材料");
    }
}
