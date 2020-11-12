package com.designpattern.建造者模式.imporve;

/**
 * @ClassName HouseDirector
 * @Description
 * @Author wzj
 * @Date 2020/10/15 15:00
 **/
//指挥者，这里去指定制作流程，最后返回产品
public class HouseDirector {

    HouseBuilder houseBuilder = null;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何处理造房子的流程，交给指挥者
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }

}
