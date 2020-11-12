package com.common.checkparameter.test;

import com.common.checkparameter.StringNotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Apple
 * @Description
 * @Author wzj
 * @Date 2020/9/14 14:36
 **/
@Data
public class Apple implements Serializable {

    @StringNotNull("苹果颜色不能为空")
    private String color;

  public static void main(String[] args) throws Exception {
String content = "abcdefghijklmnopqrstuvwxyz0123456789";
      int len = content.length();
      String c1 = "";
      String c2 = "/";
      if (len < 18) {
          c1 = content;
      } else {
          c1 = content.substring(0, 18);
          c2 = len < 23 ?
                  content.substring(18, len) :
                  content.substring(18, 23);
      }
    System.out.println(c1);
    System.out.println(c2);
  }
}
