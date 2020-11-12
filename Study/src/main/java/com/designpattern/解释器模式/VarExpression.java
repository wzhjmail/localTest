package com.designpattern.解释器模式;

import java.util.HashMap;

/**
 * @ClassName VarExpression
 * @Description 变量的解释器
 * @Author wzj
 * @Date 2020/9/15 15:06
 **/

public class VarExpression extends Expression {
    private String key; // key=a,key=b,key=c

    public VarExpression(String key) {
        this.key = key;
    }

    //var={a=10,b=20}
    //根据变量名称，返回对应值
    @Override
    int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
