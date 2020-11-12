package com.designpattern.命令模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/8/6 19:02
 **/

public class Client {
    //使用命令模式，完成通过遥控器对电灯的操作
  public static void main(String[] args) {

    //创建一个遥控器
    RemoteController remoteController = new RemoteController();


    //创建电灯的对象（接受者）
    LightReceiver lightReceiver = new LightReceiver();

    //创建电灯相关的开关按钮
    LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
    LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

    //给遥控器设置命令，如no=0 是电灯的开关操作
    remoteController.setCommand(0, lightOnCommand, lightOffCommand);

    System.out.println("----------按下电灯的开按钮--------------");
    remoteController.onButtonWasPushed(0);
    System.out.println("----------按下电灯的关按钮--------------");
    remoteController.offButtonWasPushed(0);
    System.out.println("----------按下撤销按钮--------------");
    remoteController.undoButtonWasPaushed();


    //创建电视的对象（接受者）
    TVReceiver tvReceiver = new TVReceiver();

    //创建电视相关的开关按钮
    TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
    TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);

    //给电视设置命令，如no=1 是电视的开关操作
    remoteController.setCommand(1, tvOnCommand, tvOffCommand);

    System.out.println("\n----------按下电视的开按钮--------------");
    remoteController.onButtonWasPushed(1);
    System.out.println("----------按下电视的关按钮--------------");
    remoteController.offButtonWasPushed(1);
    System.out.println("----------按下撤销按钮--------------");
    remoteController.undoButtonWasPaushed();
  }
}
