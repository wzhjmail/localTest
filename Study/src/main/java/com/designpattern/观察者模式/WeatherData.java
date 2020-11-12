package com.designpattern.观察者模式;

import lombok.Data;

/**
 * @ClassName WeatherData
 * @Description
 * @Author wzj
 * @Date 2020/9/11 15:44
 *
 **/

/**
 1、包含最新的天气情况信息
 2、含有CurrentConditions对象
 3、有数据更新时，主动调用CurrentConditions的update方法

 本类未采用设计模式，缺点：无法动态添加对接方
 */
@Data
public class WeatherData {

    private float temperature;//温度
    private float pressure;//气压
    private float humidity;//湿度

    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public void dataChange() {
        //调用接入方的更新方法
        currentConditions.update(getTemperature(),getPressure(),getHumidity());
    }

    //当数据由更新时，调用setData
    public void setData(float temperature,float pressure,float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }
}
