package com.designpattern.策略模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/9 10:22
 **/

public class Client {
  public static void main(String[] args) throws Exception{
    WildDuck wildDuck = new WildDuck();
    wildDuck.fly();

    ToyDuck toyDuck = new ToyDuck();
    toyDuck.fly();

    PekingDuck pekingDuck = new PekingDuck();
    pekingDuck.fly();

    System.out.println("北京鸭新的飞翔技术");
    pekingDuck.setFlyBehavior(new BadFlyBehavior());
    pekingDuck.fly();
  }

}
