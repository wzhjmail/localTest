package com.designpattern.工厂模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/8/18 20:09
 *
 * new子类时，首先会调用父类的构造器方法，在父类的构造器方法中引用了这个抽象方法，
 * 由于多态的性质，父类调用这个抽象方法时，会调用子类重写的该方法，
 * 所以只要在子类中实例化对象即可。
 *
 **/

public class Client {
  public static void main(String[] args) {
      //创建北京口味的各种pizza
      //new BJOrderPizza();

      // 创建伦敦口味的各种pizza
      new LDOrderPizza();
  }
}
