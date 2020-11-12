package com.designpattern.解释器模式;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName Calculator
 * @Description
 * @Author wzj
 * @Date 2020/9/15 15:20
 **/

public class Calculator {

    //定义表达式
    private Expression expression;

    //构造函数传参，并解析
    public Calculator(String expStr) {//a+b
        // 安排运算先后顺序
        Stack<Expression> stack = new Stack<>();
        //表达式拆分成字符 a,+,b
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;
    for (int i = 0; i < charArray.length; i++) {
      switch (charArray[i]) {
          case '+':
              left = stack.pop();
              right = new VarExpression(String.valueOf(charArray[++i]));
              stack.push(new AddExpression(left, right));
              break;

          case '-':
              left = stack.pop();
              right = new VarExpression(String.valueOf(charArray[++i]));
              stack.push(new SubExpression(left, right));
              break;
          default:
              stack.push(new VarExpression(String.valueOf(charArray[i])));
      }
    }
    this.expression = stack.pop();
    }

    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
