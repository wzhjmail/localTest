package com.reflect;

import com.entity.Apple;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectTest
 * @Description
 * @Author wzj
 * @Date 2020/8/5 14:50
 **/

public class ReflectTest {

  public static void main(String[] args) throws Exception{
      Class clazz = Class.forName("com.entity.Apple");
      //clazz.
      Apple apple = (Apple)clazz.getConstructor().newInstance();
      clazz.newInstance();


      Field field = clazz.getDeclaredField("color");
      //field.
      // 获取color的类型
      Class fieldType = field.getType();
      System.out.println(fieldType.getTypeName());


      Method method = clazz.getMethod("setPrice", double.class);
      Apple instance = (Apple) clazz.newInstance();
      //method.
      method.invoke(instance,2.33);
      System.out.println(instance.getPrice());


  }
}
