package com.proxy.cglib;

import com.proxy.ProxyInstance;
import com.proxy.ProxyInterface;

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
