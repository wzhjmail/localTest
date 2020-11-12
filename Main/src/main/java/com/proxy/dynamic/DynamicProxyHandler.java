package com.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxyHandler
 * @Description
 * @Author wzj
 * @Date 2020/7/31 18:14
 **/

public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("handler方式，获取name前的操作---");
        Object result = method.invoke(object, args);
        System.out.println("handler方式，获取name后的操作---");
        return result;
    }

}
