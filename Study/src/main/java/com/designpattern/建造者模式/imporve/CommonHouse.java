package com.designpattern.建造者模式.imporve;

/**
 * @ClassName CommonHouse
 * @Description
 * @Author wzj
 * @Date 2020/10/15 14:56
 **/

public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
    System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙10cm");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }
}
