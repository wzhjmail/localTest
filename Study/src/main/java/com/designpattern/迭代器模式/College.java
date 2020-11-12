package com.designpattern.迭代器模式;

import java.util.Iterator;

/**
 * @ClassName College
 * @Description
 * @Author wzj
 * @Date 2020/8/9 13:47
 **/

public interface College {
    public String getName();

    //增加系的方法
    public void addDepartment(String name,String desc);

    public Iterator createIterator();
}
