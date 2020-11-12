package com.designpattern.迭代器模式;

import java.util.Iterator;

/**
 * @ClassName Iterator
 * @Description
 * @Author wzj
 * @Date 2020/8/9 13:09
 **/

public class ComputerCollegeIterator implements Iterator {

    // 这里我们需要知道department是以怎样的方式存放
    Department[] departments;
    int position;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    //判断是否还有下一个元素
    @Override
    public boolean hasNext() {
        if(position>=departments.length||departments[position]==null)
            return false;
        return true;
    }

    @Override
    public Object next() {
        Department department=departments[position];
        position+=1;
        return department;
    }
}
