package com.designpattern.访问者模式;

/**
 * @ClassName Woman
 * @Description
 * @Author wzj
 * @Date 2020/8/7 14:39
 **/

public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
