package com.designpattern.访问者模式;

/**
 * @ClassName Action
 * @Description
 * @Author wzj
 * @Date 2020/8/7 14:37
 **/

public abstract class Action {
    // 得到男性的测评
    public abstract void getManResult(Man man);

    // 得到女性的测评
    public abstract void getWomanResult(Woman man);
}
