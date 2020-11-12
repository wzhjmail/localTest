package com.designpattern.中介者模式;

/**
 * @ClassName TV
 * @Description
 * @Author wzj
 * @Date 2020/9/14 15:53
 **/

public class TV extends Colleague {


    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void startTv(){
    System.out.println("its time to start tv");
    }

    public void stopTv(){
        System.out.println("its time to stop tv");
    }
}
