package com.designpattern.桥接模式;

/** @ClassName XiaoMi @Description @Author wzj @Date 2020/10/16 13:46 */
public class XiaoMi implements Brand {

  @Override
  public void open() {
    System.out.println("小米手机开机");
  }

  @Override
  public void close() {
    System.out.println("小米手机关机");
  }

  @Override
  public void call() {
    System.out.println("小米手机打电话");
  }
}
