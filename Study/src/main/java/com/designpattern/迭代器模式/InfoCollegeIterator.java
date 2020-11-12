package com.designpattern.迭代器模式;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName InfoCollegeIterator
 * @Description
 * @Author wzj
 * @Date 2020/8/9 13:38
 **/

public class InfoCollegeIterator implements Iterator {

    List<Department> departmentList;//信息工程学院以list方式存放
    int index=-1;

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if(index>=departmentList.size()-1){
            return false;
        }
        index+=1;
        return true;
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }
}
