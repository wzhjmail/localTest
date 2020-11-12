package com.designpattern.命令模式;

/**
 * @ClassName TVOffCommand
 * @Description
 * @Author wzj
 * @Date 2020/8/7 10:02
 **/

public class TVOffCommand implements Command {
    // 聚合TVReceiver
    TVReceiver tv;

    public TVOffCommand(TVReceiver tvReceiver) {
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
