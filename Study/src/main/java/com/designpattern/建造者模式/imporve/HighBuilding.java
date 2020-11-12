package com.designpattern.建造者模式.imporve;

/**
 * @ClassName HighBuilding
 * @Description
 * @Author wzj
 * @Date 2020/10/15 14:58
 **/

public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
    System.out.println("高楼打地基20米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙20cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼feng ding ");
    }
}
