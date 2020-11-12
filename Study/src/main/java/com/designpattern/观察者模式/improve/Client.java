package com.designpattern.观察者模式.improve;

import java.util.ArrayList;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/9/11 18:47
 **/

public class Client {

    public static void main(String[] args){
        ArrayList<Observer> observers = new ArrayList<>();
        //创建 一个weatherData
        WeatherData weatherData = new WeatherData(observers);

        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();

        //注册到weatherData
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);

        // 移除
        weatherData.removeObserver(currentConditions);

        //测试
        System.out.println("通知各个注册的观察者，看看信息");
        weatherData.setData(10f, 100f, 33.3f);
    }

}
