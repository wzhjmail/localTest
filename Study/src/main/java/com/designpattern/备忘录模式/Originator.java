package com.designpattern.备忘录模式;

import lombok.Data;

/**
 * @ClassName Originator
 * @Description
 * @Author wzj
 * @Date 2020/9/14 18:21
 **/
@Data
public class Originator {

    private String state;//状态信息

    // 保存一个状态对象 Memento
    public Memento saveStateMemento(){
        return new Memento(state);
    }

    // 通过备忘录对象，恢复状态
    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
