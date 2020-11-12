package com.designpattern.访问者模式;

/**
 * @ClassName Person
 * @Description
 * @Author wzj
 * @Date 2020/8/7 14:39
 **/

public abstract class Person {
    //提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}
