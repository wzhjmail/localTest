package com.dubbo;

import lombok.Data;

import java.lang.reflect.Method;

/** @ClassName Par @Description @Author wzj @Date 2020/8/21 13:53 */
@Data
public class Par {
  private int id;

  public static String getMethodName(String fileName) {
    byte[] items = fileName.getBytes();
    items[0] = (byte) ((char) items[0] - 'a' + 'A');
    String result = new String(items);
    return "get" + result;
  }

  private static Object getValue(Object object, String fileName) {

    try {

      String[] names = fileName.split("\\.");
      Method getMethod = object.getClass().getMethod(getMethodName(names[0]));
      object = getMethod.invoke(object);

      if (names.length == 1) {
        return object;
      }

      String subFileName = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
      return getValue(object, subFileName);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return object;
  }

  public static void main(String[] args) {
    String str = "1234567890";
    int len = 1801;
    if (len < 1800) {
      System.out.println(1);
    } else if (len < 2300) {
      System.out.println(2);
    } else {
      System.out.println(3);
    }
  }
}
