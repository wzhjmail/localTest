package com.designpattern.工厂模式;

/**
 * @ClassName LDOrderPizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 20:06
 **/

public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        } else if (orderType.equals("papper")) {
            pizza = new LDPeeperPizza();
        }
        return pizza;
    }
}
