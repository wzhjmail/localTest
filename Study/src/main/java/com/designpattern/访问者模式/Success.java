package com.designpattern.访问者模式;

/**
 * @ClassName Success
 * @Description
 * @Author wzj
 * @Date 2020/8/7 14:39
 **/

public class Success extends Action {
    @Override
    public void getManResult(Man man) {
    System.out.println("男人给的评价：该歌手很成功！");
    }

    @Override
    public void getWomanResult(Woman man) {
        System.out.println("女人给的评价：该歌手很成功！");
    }
}
