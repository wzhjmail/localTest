package com.designpattern.原型模式;

import java.io.Serializable;

/**
 * @ClassName DeepCloneableTarget
 * @Description
 * @Author wzj
 * @Date 2020/10/13 16:06
 **/

public class DeepCloneableTarget implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String nickName;

    public DeepCloneableTarget(String name, String nickName){
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
