package com.designpattern.解释器模式;

import java.util.HashMap;

/**
 * @ClassName SymbolExpression
 * @Description
 * 抽象运算符号解析器 每个运算符号都只和自己左右两个数字有关
 * 单左右两个数字可能是一个解析的结果，无论何种类型，都是Expression类的实现类
 * @Author wzj
 * @Date 2020/9/15 15:09
 **/

public class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    //SymbolExpression是让其子类实现的，因此interpreter是一个默认实现
    @Override
    int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
