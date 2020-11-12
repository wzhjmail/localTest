package com.proxy.dynamic;

import com.proxy.ProxyInstance;
import com.proxy.ProxyInterface;

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

    System.out.println("------------------");
    // factory
    DynamicProxyFactory factory = new DynamicProxyFactory(instance);
    ProxyInterface proxyInterface2 = (ProxyInterface)factory.getProxyInstance();
    proxyInterface2.getName("mac");
  }
}
