package com.designpattern.观察者模式.improve;

/**
 * @ClassName Subject
 * @Description
 * @Author wzj
 * @Date 2020/9/11 18:32
 **/
// 让weatherData来实现
public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();

}
