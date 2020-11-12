package com.designpattern.享元模式;

/**
 * @ClassName User
 * @Description
 * @Author wzj
 * @Date 2020/8/7 10:59
 **/

public class User {
    private String name;

    public User(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
