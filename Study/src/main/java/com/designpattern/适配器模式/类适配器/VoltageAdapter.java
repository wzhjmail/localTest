package com.designpattern.适配器模式.类适配器;

/**
 * @ClassName VoltageAdapter
 * @Description
 * @Author wzj
 * @Date 2020/10/15 15:40
 **/
//适配器类
public class VoltageAdapter extends Voltage220V implements IVolate5V{
    @Override
    public int output5V() {
         //获取到220V电压
        int srcV = output220V();
        int dstV =srcV/44;

        return dstV;
    }
}
