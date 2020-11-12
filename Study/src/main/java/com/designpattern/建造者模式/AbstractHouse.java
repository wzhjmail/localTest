package com.designpattern.建造者模式;

/**
 * @ClassName AbstractHouse
 * @Description
 * @Author wzj
 * @Date 2020/10/15 14:16
 **/

public abstract class AbstractHouse {

    //打地基
    public abstract void buildBasic();

    //砌墙
    public abstract void buildWalls();

    //封顶
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
