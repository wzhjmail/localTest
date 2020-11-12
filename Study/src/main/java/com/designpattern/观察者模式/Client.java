package com.designpattern.观察者模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/8/11 17:35
 **/

public class Client {

  public static void main(String[] args) {
    //创建接入方
    CurrentConditions currentConditions = new CurrentConditions();
    //创建weatherData并将接入方传入
    WeatherData weatherData = new WeatherData(currentConditions);

    // 更新天气情况
    weatherData.setData(30,150,40);

    // 天气情况变化
    System.out.println("==========天气情况变化==========");
    weatherData.setData(20, 160,20);
  }
}
