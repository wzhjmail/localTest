package com.designpattern.组合模式;

import lombok.Data;

/**
 * @ClassName OrganizationComponent
 * @Description
 * @Author wzj
 * @Date 2020/10/16 16:21
 **/
@Data
public abstract class OrganizationComponent {

    private String name;//名字
    private String des;//说明

    protected void add(OrganizationComponent organizationComponent) {
        //默认实现
        throw new UnsupportedOperationException();

    }

    protected void remove(OrganizationComponent organizationComponent) {
        //默认实现
        throw new UnsupportedOperationException();

    }

    //构造器
    public OrganizationComponent(String name, String des){
        this.name = name;
        this.des = des;
    }

    //打印方法
    public abstract void print();
}
