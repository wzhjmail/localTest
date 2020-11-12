package com.designpattern.工厂模式;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName OrderPizza
 * @Description
 * @Author wzj
 * @Date 2020/8/18 20:00
 *
 * 具体实现是在父类中定义一个抽象方法，然后在父类的构造器中调用这个抽象方法，
 * 然后在子类中实现这个抽象方法，这个抽象方法所实现的内容就是对象的实例化。
 *
 **/

public abstract class OrderPizza {

    //定义一个抽象方法，createPizza，让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    //构造器
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do{
            orderType = getType();
            pizza = createPizza(orderType);//抽象方法，由工厂子类完成
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
