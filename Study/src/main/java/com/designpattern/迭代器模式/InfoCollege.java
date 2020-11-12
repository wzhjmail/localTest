package com.designpattern.迭代器模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName InfoCollege
 * @Description
 * @Author wzj
 * @Date 2020/8/9 14:02
 **/

public class InfoCollege implements College {
    List<Department> departmentList;

    public InfoCollege(){
        departmentList = new ArrayList<Department>();
        addDepartment("信息安全", "信息安全");
        addDepartment("网络安全", "网络安全");
        addDepartment("服务器安全", "服务器安全");
    }
    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departmentList.add(new Department(name,desc));
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
