package com.designpattern.原型模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/12 10:14
 **/

public class Client {

  public static void main(String[] args) throws Exception{
    //
    Sheep sheep = new Sheep("tom", 1, "白色");

    Sheep sheep1 = (Sheep) sheep.clone();
    Sheep sheep2 = (Sheep) sheep.clone();
    Sheep sheep3 = (Sheep) sheep.clone();
    Sheep sheep4 = (Sheep) sheep.clone();
    Sheep sheep5 = (Sheep) sheep.clone();

    System.out.println("sheep2 = " + sheep2);
    System.out.println("sheep3 = " + sheep3);
    System.out.println("sheep4 = " + sheep4);
    System.out.println("sheep5 = " + sheep5);

    System.out.println();
    System.out.println("----------深拷贝方式一：clone------------");
    System.out.println();
    // 深拷贝的方式一：通过clone方式
    DeepPrototype p = new DeepPrototype();
    p.name="松江";
    p.deepCloneableTarget = new DeepCloneableTarget("大牛","小牛");
    //完成深度拷贝
    DeepPrototype p2 = (DeepPrototype)p.clone();

    System.out.println("p.name=" + p.name + "    p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
    System.out.println("p2.name=" + p2.name + "  p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());

    System.out.println();
    System.out.println("----------深拷贝方式二：序列化（推荐使用）------------");
    System.out.println();
    // 深拷贝方式二：序列化（推荐使用）
    DeepPrototype p3 = (DeepPrototype)p.deelClone();
    System.out.println("p.name=" + p.name + "    p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
    System.out.println("p3.name=" + p3.name + "  p3.deepCloneableTarget=" + p3.deepCloneableTarget.hashCode());

  }
}
