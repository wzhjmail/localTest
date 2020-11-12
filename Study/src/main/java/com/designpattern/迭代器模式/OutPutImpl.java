package com.designpattern.迭代器模式;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName OutPutInpl
 * @Description
 * @Author wzj
 * @Date 2020/8/9 14:08
 **/

public class OutPutImpl {

    //学院集合
    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList=collegeList;
    }

    //遍历所有学院，然后调用printDepartment输出所有系
    public void printCollege() {
        Iterator<College> iterator= collegeList.iterator();
        while(iterator.hasNext()){
            College college = iterator.next();
      System.out.println("========="+college.getName()+"==========");
            printDepartment(college.createIterator());
        }
    }

    //输出学院下的所有系
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()) {
            Department department = (Department)iterator.next();
      System.out.println(department.getName());
        }
    }

}
