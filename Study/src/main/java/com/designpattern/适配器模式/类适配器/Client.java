package com.designpattern.适配器模式.类适配器;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/15 15:21
 **/

public class Client {
  public static void main(String[] args) {
    //
    System.out.println("======类适配器模式======");
     Phone phone = new Phone();
      VoltageAdapter adapter = new VoltageAdapter();

     phone.charging(adapter);

  }
}
