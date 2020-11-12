package com.designpattern.命令模式;

/**
 * @ClassName LightOnCommand
 * @Description
 * @Author wzj
 * @Date 2020/8/6 17:34
 **/

public class LightOnCommand implements Command {
    // 聚合LightReceiver
    LightReceiver light;

    public LightOnCommand(LightReceiver light){
        super();
        this.light=light;
    }

    @Override
    public void execute() {
        // 调用接受者的方法
        light.on();
    }

    @Override
    public void undo() {
// 调用接受者的方法
        light.off();
    }
}
