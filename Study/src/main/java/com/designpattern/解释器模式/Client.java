package com.designpattern.解释器模式;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.HashMap;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/9/15 14:26
 **/

public class Client {
  public static void main(String[] args) {
    //
      String expStr = "a+b-c";
      HashMap<String, Integer> var = new HashMap<>();
      var.put("a",1);
      var.put("b",2);
      var.put("c",3);
      Calculator calculator = new Calculator(expStr);
    System.out.println("运算结果："+ expStr +"="+calculator.run(var));


      SpelExpressionParser parser = new SpelExpressionParser();
      Expression expression = parser.parseExpression("10*(1+2)+3");
    System.out.println(expression.getValue());
  }



}
