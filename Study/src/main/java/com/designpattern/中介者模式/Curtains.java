package com.designpattern.中介者模式;

/**
 * @ClassName Curtains
 * @Description
 * @Author wzj
 * @Date 2020/9/14 15:52
 **/

public class Curtains extends Colleague {
    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    public void sendMessage(int stageChange) {
        this.getMediator().getMessage(stageChange, this.name);
    }

    public void upCurtains() {
    System.out.println("im holding up curtains!");
    }

    public void downCurtains() {
        System.out.println("im putting down curtains!");
        sendMessage(0);

    }
}
