package com.designpattern.观察者模式.improve;

/**
 * @ClassName Observer
 * @Description
 * @Author wzj
 * @Date 2020/9/11 18:34
 **/
// 观察者接口，由观察者来实现
public interface Observer {

    void update(float temperature, float pressure, float humidity);

}
