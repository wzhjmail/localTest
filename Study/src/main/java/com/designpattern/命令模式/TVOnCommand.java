package com.designpattern.命令模式;

/**
 * @ClassName TVOnCommand
 * @Description
 * @Author wzj
 * @Date 2020/8/7 10:00
 **/

public class TVOnCommand implements Command {
    //聚合TVReceiver
    TVReceiver tv;

    public TVOnCommand(TVReceiver tvReceiver){
        super();
        this.tv=tvReceiver;
    }
    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
tv.off();
    }
}
