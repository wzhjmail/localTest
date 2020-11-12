package com.designpattern.抽象工厂模式;

import com.designpattern.工厂模式.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName OrderPizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 20:45
 **/

public class OrderPizza {
    private IFactory factory;

    public OrderPizza(IFactory factory){
        setFactory(factory);
    }

    public void setFactory(IFactory factory) {
        Pizza pizza = null;
        String orderType="";
        this.factory = factory;

        do{
            orderType = getType();
            pizza = factory.createPizza(orderType);//抽象方法，由工厂子类完成
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
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
