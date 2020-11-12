package com.designpattern.备忘录模式.game;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName Caretaker
 * @Description
 * @Author wzj
 * @Date 2020/9/15 10:17
 **/
//守护者对象，保存游戏角色的状态
@Data
public class Caretaker {

    //如果只保存一次状态
    private Memento memento;

    //对GameRole保存多次状态
    private ArrayList<Memento> mementos;

    //对多个游戏角色保存多个状态
    private HashMap<String, ArrayList<Memento>> rolesMementos;
}
