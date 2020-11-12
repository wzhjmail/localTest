package com.designpattern.模板方法;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/8/6 16:39
 **/

public class Client {
  public static void main(String[] args) {
    //
    System.out.println("-------开始制作红豆豆浆--------");
      SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
      redBeanSoyaMilk.make();

      System.out.println("-------开始制作花生豆浆--------");
      SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
      peanutSoyaMilk.make();
   }
}
