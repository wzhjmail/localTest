package com.designpattern.中介者模式;

/**
 * @ClassName Mediator
 * @Description 中介者：将各个设备之间的调用关系修改为他们之间的关系由一个中介类实现
 * @Author wzj
 * @Date 2020/9/14 15:56
 **/

public abstract class Mediator {
    //将中介者对象，加入到集合中
    abstract void register(String colleagueName, Colleague colleague);

    //接受消息，具体的同事对象发出
    abstract void getMessage(int stateChange, String colleagueName);

    abstract void sendMessage();
}
