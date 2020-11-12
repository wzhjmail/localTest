package com.designpattern.抽象工厂模式;

import com.designpattern.工厂模式.LDCheesePizza;
import com.designpattern.工厂模式.LDPeeperPizza;
import com.designpattern.工厂模式.Pizza;

/**
 * @ClassName LDFactory
 * @Description
 * @Author wzj
 * @Date 2020/8/18 20:42
 **/

public class LDFactory implements IFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
            pizza.setName("cheese");
        } else if (orderType.equals("peeper")){
            pizza = new LDPeeperPizza();
            pizza.setName("peeper");
        }
        return pizza;
    }
}
