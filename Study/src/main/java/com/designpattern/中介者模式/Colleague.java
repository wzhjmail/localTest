package com.designpattern.中介者模式;

/**
 * @ClassName Colleague
 * @Description
 * @Author wzj
 * @Date 2020/9/14 15:44
 **/
// 同事抽象类
public abstract class Colleague {

    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator(){
        return this.mediator;
    }

    public abstract void sendMessage(int stateChange);
}
