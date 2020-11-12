package com.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxyFactory
 * @Description
 * @Author wzj
 * @Date 2020/8/2 11:28
 **/

public class DynamicProxyFactory {
    private Object target;

    public DynamicProxyFactory(final Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("factory方式，获取name前的操作");
                        Object result = method.invoke(target, args);
                        System.out.println("factory方式，获取name后的操作");
                        return result;
                    }
                });
    }

}
