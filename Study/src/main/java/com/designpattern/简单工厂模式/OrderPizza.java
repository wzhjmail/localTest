package com.designpattern.简单工厂模式;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName OrderPizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 10:31
 **/

public class OrderPizza {
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
        String orderType = ""; // 用户输入的值
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            //输出披萨
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购披萨失败");
                break;
            }
        } while (true);
    }

    private String getType() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
      System.out.println("input pizza type:");
      String str = br.readLine();
      return str;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
