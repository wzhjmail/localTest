package com.designpattern.代理模式.dynamic;


import com.designpattern.代理模式.ProxyInstance;
import com.designpattern.代理模式.ProxyInterface;

import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxyTest
 * @Description
 * @Author wzj
 * @Date 2020/8/5 15:22
 **/

public class DynamicProxyTest {
  public static void main(String[] args) {

    ProxyInstance instance = new ProxyInstance();

    // Handler
    ProxyInterface proxyInterface = (ProxyInterface) Proxy.newProxyInstance(
            ProxyInterface.class.getClassLoader(),
            new Class[]{ProxyInterface.class},
            new DynamicProxyHandler(instance));
    proxyInterface.getName("123");


    // factory
    DynamicProxyFactory factory = new DynamicProxyFactory(instance);
    ProxyInterface proxyInterface2 = (ProxyInterface)factory.getProxyInstance();
    proxyInterface2.getName("mac");
  }
}
