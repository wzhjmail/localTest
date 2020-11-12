package com.designpattern.命令模式;

/** @ClassName RemoteController @Description @Author wzj @Date 2020/8/6 17:43 */
//遥控器类：第一行有两个按钮代表：电灯开，电灯关
  //      第二行有两个按钮代表：电视开，电视关
  //总共可以有五行，还有一个撤销按钮
public class RemoteController {

  // 开按钮的命令数组
  Command[] onCommands;
  Command[] offCommands;

  // 执行撤销的命令
  Command undoCommand;

  // 构造器，完成对按钮对初始化
  public RemoteController() {
    onCommands = new Command[5];
    offCommands = new Command[5];

    for (int i = 0; i < 5; i++) {
      onCommands[i] = new NoCommand();
      offCommands[i] = new NoCommand();
    }
  }

  //给按钮设置需要的命令
    public void setCommand(int no, Command onCommand, Command offCommand){
        onCommands[no] =onCommand;
        offCommands[no] =offCommand;
    }

    // 按下开按钮
    public void onButtonWasPushed(int no) {
      //找到你按下的开的按钮，并调用对应方法
        onCommands[no].execute();
        undoCommand=onCommands[no];
    }

    // 按下关按钮
    public void offButtonWasPushed(int no) {
        //找到你按下的关的按钮，并调用对应方法
        offCommands[no].execute();
        undoCommand=offCommands[no];
    }

    // 按下撤销按钮
    public void undoButtonWasPaushed() {
      undoCommand.undo();
    }

}
