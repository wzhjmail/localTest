package com.designpattern.访问者模式;

/**
 * @ClassName Man
 * @Description
 * @Author wzj
 * @Date 2020/8/7 14:39
 **/
// 这里使用双分派，即首先在客户端程序中，将具体状态作为参数传递man中（第一次分派）
// 然后Man类调用作为参数的"具体方法"中方法getManResult，同时将自己this作为参数传入，完成第二次分派
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
