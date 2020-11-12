package com.designpattern.备忘录模式;

import lombok.Data;

/**
 * @ClassName Memento
 * @Description
 * @Author wzj
 * @Date 2020/9/14 19:33
 **/
@Data
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }


}
