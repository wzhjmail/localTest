package com.designpattern.访问者模式;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ObjectStructure
 * @Description
 * @Author wzj
 * @Date 2020/8/7 14:48
 **/
// 数据结构，管理很多人man,woman
public class ObjectStructure {
    // 维护了一个集合
    private List<Person> personList = new LinkedList<>();

    public void attach(Person p) {
        personList.add(p);
    }
    public void detach(Person p) {
        personList.remove(p);
    }

    //显示测评情况
    public void display(Action action) {
        for(Person p:personList){
            p.accept(action);
        }
    }
}
