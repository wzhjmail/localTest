package com.designpattern.装饰者模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/16 14:22
 * 装饰者模式：动态地将新功能添加到对象上
 **/

public class Client {
  public static void main(String[] args) {
      // 装饰者模式下的订单：2份巧克力+一份牛奶的LongBlack

      //1、点一份LongBlack
      Drink order = new LongBlack();
      System.out.println("费用1 = " + order.cost());
      System.out.println("描述：" +order.getDesc());

    //2、order中加入一份牛奶
      order = new Milk(order);
      System.out.println("order中加入一份牛奶费用 = " + order.cost());
      System.out.println("order中加入一份牛奶描述：" +order.getDesc());

      //3、order中加入一份巧克力
      order = new Chocolate(order);
      System.out.println("order中加入一份牛奶和一份巧克力费用 = " + order.cost());
      System.out.println("order中加入一份牛奶和一份巧克力描述：" +order.getDesc());

      //3、order中加入第二份巧克力
      order = new Chocolate(order);
      System.out.println("order中加入一份牛奶和二份巧克力费用 = " + order.cost());
      System.out.println("order中加入一份牛奶和二份巧克力描述：" +order.getDesc());

    System.out.println();
      Drink order2 = new Decaf();
      System.out.println("订单2 费用 = " + order2.cost());
      System.out.println("订单2描述：" +order2.getDesc());

      order2 = new Milk(order2);
      System.out.println("订单2 加入一份牛奶 费用 = " + order2.cost());
      System.out.println("订单2 加入一份牛奶 描述：" +order2.getDesc());
  }
}
