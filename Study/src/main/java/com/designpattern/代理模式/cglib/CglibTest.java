package com.designpattern.代理模式.cglib;

import com.designpattern.代理模式.ProxyInstance;
import com.designpattern.代理模式.ProxyInterface;

/**
 * @ClassName CglibText
 * @Description
 * @Author wzj
 * @Date 2020/7/31 17:23
 **/

public class CglibTest {

  public static void main(String[] args) throws Throwable {

      CglibProxy cglib = new CglibProxy();
      ProxyInterface instance = new ProxyInstance();
      ProxyInstance tt= (ProxyInstance)cglib.getInstance(instance);
      tt.getName("666");

      System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

  }
}
