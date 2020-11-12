package com.designpattern.解释器模式;

import java.util.HashMap;

/**
 * @ClassName Expression
 * @Description 抽象类表达式，通过hashMap获取变量的值
 * @Author wzj
 * @Date 2020/9/15 14:38
 **/

public abstract class Expression {

    // a+b-c
    // 解释公式和数字，hashMap{a=10,b=20}
    abstract int interpreter(HashMap<String, Integer> var);

}
