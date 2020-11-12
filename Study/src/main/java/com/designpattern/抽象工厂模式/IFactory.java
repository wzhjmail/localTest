package com.designpattern.抽象工厂模式;

import com.designpattern.工厂模式.Pizza;

/**
 * @ClassName IFactory
 * @Description
 * @Author wzj
 * @Date 2020/8/18 20:41
 **/

public interface IFactory {
    Pizza createPizza(String orderType);
}
