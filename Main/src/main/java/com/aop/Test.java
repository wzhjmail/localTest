package com.aop;

import com.LocalTestApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Test
 * @Description
 * @Author wzj
 * @Date 2020/8/3 17:50
 **/

public class Test {
  public static void main(String[] args) {

      AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(LocalTestApplication.class);
      annotationConfigApplicationContext.getBean("");

  }
}
