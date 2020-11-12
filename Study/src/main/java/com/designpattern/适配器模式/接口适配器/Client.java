package com.designpattern.适配器模式.接口适配器;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/15 16:29
 **/

public class Client {
  public static void main(String[] args) {
    //
     AbsAdapter absAdapter = new AbsAdapter() {
         //只需要去覆盖我们需要使用的接口方法
         public void m1() {
             System.out.println("使用了m1的方法");
         }
     };
     absAdapter.m1();
  }
}
