package com.designpattern.模板方法;

/**
 * @ClassName PeanutSoyaMilk
 * @Description
 * @Author wzj
 * @Date 2020/8/6 16:38
 **/

public class PeanutSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
    System.out.println("添加上好的花生。。。");
    }
}
