package com.designpattern.建造者模式.imporve;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/15 14:49
 **/

public class Client {

  public static void main(String[] args) {
    //盖普通贩子
      CommonHouse commonHouse = new CommonHouse();
      //准备创建房子的指挥者
      HouseDirector houseDirector = new HouseDirector(commonHouse);

      //完成盖房子，返回产品
      House house = houseDirector.constructHouse();
    System.out.println();
        //盖高楼
      HighBuilding highBuilding = new HighBuilding();
      houseDirector.setHouseBuilder(highBuilding);
      houseDirector.constructHouse();
  }
}
