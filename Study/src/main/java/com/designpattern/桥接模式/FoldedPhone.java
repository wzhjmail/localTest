package com.designpattern.桥接模式;

/**
 * @ClassName FoldedPhone
 * @Description
 * @Author wzj
 * @Date 2020/10/16 13:52
 **/

public class FoldedPhone extends Phone {

    // 构造器
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
    System.out.println("折叠样式手机");
    }

    public void close(){
        super.close();
        System.out.println("折叠样式手机");
    }

    public void call(){
        super.call();
        System.out.println("折叠样式手机");
    }
}

