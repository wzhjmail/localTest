package com.designpattern.中介者模式;

/**
 * @ClassName Alarm
 * @Description
 * @Author wzj
 * @Date 2020/9/14 15:47
 **/

public class Alarm extends Colleague {
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        //在创建Alarm同事对象时，将自己放入到ConcreteMediator对象的集合中
        mediator.register(name, this);
    }

    public void sendAlarm(int stateChange){
        sendMessage(stateChange);
    }

    public void sendMessage(int stateChange){
        this.getMediator().getMessage(stateChange, this.name);
    }
}
