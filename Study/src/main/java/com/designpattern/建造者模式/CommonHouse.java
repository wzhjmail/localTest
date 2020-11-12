package com.designpattern.建造者模式;

/**
 * @ClassName CommonHouse
 * @Description
 * @Author wzj
 * @Date 2020/10/15 14:20
 **/

public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
    System.out.println("给普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("给普通房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("给普通房子封顶");
    }
}
