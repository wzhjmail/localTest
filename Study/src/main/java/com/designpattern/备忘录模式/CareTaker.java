package com.designpattern.备忘录模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CareTaker
 * @Description
 * @Author wzj
 * @Date 2020/9/15 10:00
 **/

public class CareTaker {

    //集合中由许多备忘录对象
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    //获取到第index个originator的备忘录对象（即保存状态）
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
