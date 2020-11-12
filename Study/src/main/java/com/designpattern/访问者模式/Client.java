package com.designpattern.访问者模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/8/7 14:25
 **/

public class Client {
  public static void main(String[] args) {
    //创建ObjectStructure
      ObjectStructure objectStructure = new ObjectStructure();
      objectStructure.attach(new Man());
      objectStructure.attach(new Woman());

      //成功
      Success success = new Success();
      objectStructure.display(success);

      //失败
      Fail fail = new Fail();
      objectStructure.display(fail);

      //待定
      Wait wait = new Wait();
      objectStructure.display(wait);
  }
}
