package com.designpattern.组合模式;

/**
 * @ClassName Department
 * @Description
 * @Author wzj
 * @Date 2020/10/16 17:23
 **/

public class Department extends OrganizationComponent {
    //没有集合


    public Department(String name, String des) {
        super(name, des);
    }

    // add remove就不用写了，因为他是叶子节点

    @Override
    public void print() {
    System.out.println(getName());
    }
}
