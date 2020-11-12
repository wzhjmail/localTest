package com.designpattern.工厂模式;

/**
 * @ClassName LDPeeperPizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 19:59
 **/

public class LDPeeperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的胡椒披萨");
        System.out.println("伦敦的胡椒披萨 准备原材料");
    }
}
