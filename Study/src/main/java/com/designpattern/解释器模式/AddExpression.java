package com.designpattern.解释器模式;

import java.util.HashMap;

/**
 * @ClassName AddExpression
 * @Description
 * @Author wzj
 * @Date 2020/9/15 15:13
 **/

public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    //处理相加，var仍然是{a=10,b=20}
    //super.left.interpreter(var):返回left表达式的值a=10
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
