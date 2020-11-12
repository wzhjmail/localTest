package com.designpattern.抽象工厂模式;

import com.designpattern.工厂模式.BJCheesePizza;
import com.designpattern.工厂模式.BJPeeperPizza;
import com.designpattern.工厂模式.Pizza;

/**
 * @ClassName BJFactory
 * @Description
 * @Author wzj
 * @Date 2020/8/18 20:42
 **/

public class BJFactory implements IFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
            pizza.setName("cheese");
        } else if (orderType.equals("peeper")){
            pizza = new BJPeeperPizza();
            pizza.setName("peeper");
        }
        return pizza;
    }
}
