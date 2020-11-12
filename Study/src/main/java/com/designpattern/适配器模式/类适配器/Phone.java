package com.designpattern.适配器模式.类适配器;

/**
 * @ClassName Phone
 * @Description
 * @Author wzj
 * @Date 2020/10/15 15:42
 **/

public class Phone {
    //充电
    public void charging(IVolate5V iVolate5V) {
        if(iVolate5V.output5V() == 5){
      System.out.println("电压为5V，可以充电");
        }else  if(iVolate5V.output5V() > 5) {
      System.out.println("电压大于5V，不能充电");
        }
    }
}
