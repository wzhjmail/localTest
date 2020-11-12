package com.designpattern.迭代器模式;

/**
 * @ClassName Depart
 * @Description
 * @Author wzj
 * @Date 2020/8/9 13:23
 **/


//系
public class Department {
    private String name;
    private String desc;

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
