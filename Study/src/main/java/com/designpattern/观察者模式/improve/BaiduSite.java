package com.designpattern.观察者模式.improve;

/**
 * @ClassName BauduSite
 * @Description
 * @Author wzj
 * @Date 2020/9/11 19:03
 **/

public class BaiduSite implements Observer{
    private float temperature;//温度
    private float pressure;//气压
    private float humidity;//湿度

    //更新天气情况 由weatherData来调用，使用推送模式
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println(
                " 百度temperature = " +temperature +
                        "\n 百度pressure = "+ pressure+
                        "\n 百度humidity = "+humidity);
    }
}
