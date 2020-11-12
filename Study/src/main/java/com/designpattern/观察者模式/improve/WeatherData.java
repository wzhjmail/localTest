package com.designpattern.观察者模式.improve;

import lombok.Data;

import java.util.ArrayList;

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
 3、有数据更新时，主动调用ArrayList,通知所有接入方,就能看到最新的消息
 */
@Data
public class WeatherData implements Subject{

    private float temperature;//温度
    private float pressure;//气压
    private float humidity;//湿度

    //观察者集合
    private ArrayList<Observer> observers;

    public WeatherData(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public void dataChange() {
        //调用接入方的更新方法
        notifyObserver();
    }

    //当数据由更新时，调用setData
    public void setData(float temperature,float pressure,float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    // 注册一个观察者
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    //删除一个观察者
    @Override
    public void removeObserver(Observer observer) {
        if(observers.contains(observer))
        observers.remove(observer);
    }

    // 遍历所有的观察者，并通知
    @Override
    public void notifyObserver() {
    for (int i = 0; i < observers.size(); i++) {
        observers.get(i).update(this.temperature, this.pressure,this.humidity);
    }
    }
}
