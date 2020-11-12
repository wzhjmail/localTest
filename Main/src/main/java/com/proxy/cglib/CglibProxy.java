package com.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/** @ClassName CglibOfNet @Description @Author wzj @Date 2020/7/31 17:22 */
public class CglibProxy implements MethodInterceptor {
  private Object target;

  public Object getInstance(final Object target) {
    this.target = target;
    // 创建工具类
    Enhancer enhancer = new Enhancer();
    // 设置父类
    enhancer.setSuperclass(this.target.getClass());
    // 设置回调函数
    enhancer.setCallback(this);
    // 创建子类对象，即代理对象
    return enhancer.create();
  }

  // 重写intercept方法，会调用目标对象的方法
  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("cglib代理调用方法前");
    Object result = methodProxy.invoke(target, args);
    System.out.println("cglib代理调用方法后");
    return result;
  }
}
