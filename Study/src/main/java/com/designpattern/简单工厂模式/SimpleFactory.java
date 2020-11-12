package com.designpattern.简单工厂模式;

/**
 * @ClassName SimpleFactory
 * @Description
 * @Author wzj
 * @Date 2020/8/18 11:04
 * 将对象的创建过程抽离出来，形成单独的一个类，这个类就叫做“工厂”，
并且工厂类中的方法会返回一个抽象类的引用，这里就是Pizza类，
通过多态的特性，可以调用到子类中Override的方法。这样，当要用到具体类的时候，
可以直接通过工厂类生成对象，修改时，也只用修改工厂类。
 **/

public class SimpleFactory {
    //根据orderType返回对应的Pizza对象
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希纳披萨");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨");
        }
        return pizza;
    }
}
