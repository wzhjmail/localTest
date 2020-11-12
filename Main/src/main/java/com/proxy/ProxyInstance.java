package com.proxy;

/** @ClassName ProxyInstance @Description @Author wzj @Date 2020/7/31 17:38 */
public class ProxyInstance implements ProxyInterface{

  public String getName(String name) {
    System.out.println("获取参数name:" + name);
    return name;
  }
}