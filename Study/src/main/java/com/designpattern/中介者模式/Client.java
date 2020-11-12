package com.designpattern.中介者模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/9/14 15:16
 **/

public class Client {

    public static void main(String[] args){
        //创建一个中介对象
        Mediator mediator = new ConcreteMediator();

        //创建Alarm并且加到ConcreteMediator对象的hashmap
        Alarm alarm = new Alarm(mediator, "alarm");
        Curtains curtains = new Curtains(mediator, "curtains");
        TV tv = new TV(mediator, "tv");
        alarm.sendAlarm(0);
        //alarm.sendAlarm(1);
    }

}
