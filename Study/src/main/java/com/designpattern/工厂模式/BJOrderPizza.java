package com.designpattern.工厂模式;

/**
 * @ClassName BJOrderPizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 20:06
 **/

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        } else if (orderType.equals("peeper")) {
            pizza = new BJPeeperPizza();
        }
        return pizza;
    }
}
