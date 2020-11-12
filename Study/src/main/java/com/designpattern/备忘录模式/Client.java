package com.designpattern.备忘录模式;

/** @ClassName Client @Description @Author wzj @Date 2020/9/14 18:15 */
public class Client {

  public static void main(String[] args) {
    //
    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();

    originator.setState("状态#1 攻击力100");
    // 保存了当前的状态
    careTaker.add(originator.saveStateMemento());

    originator.setState("状态#2 攻击力80");
    careTaker.add(originator.saveStateMemento());

    originator.setState("状态#3 攻击力50");
    careTaker.add(originator.saveStateMemento());

    System.out.println("当前的状态是=" + originator.getState());

    // 希望恢复到状态1,将originator恢复到状态1
    originator.getStateFromMemento(careTaker.get(0));

    System.out.println("恢复到状态1：");
    System.out.println("当前的状态是=" + originator.getState());
  }
}
