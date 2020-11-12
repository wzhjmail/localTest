package com.designpattern.桥接模式;

/**
 * @ClassName UpRightPhone
 * @Description
 * @Author wzj
 * @Date 2020/10/16 13:58
 **/

public class UpRightPhone extends Phone {
    public UpRightPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("直立样式手机");
    }

    public void close(){
        super.close();
        System.out.println("直立样式手机");
    }

    public void call(){
        super.call();
        System.out.println("直立样式手机");
    }
}
