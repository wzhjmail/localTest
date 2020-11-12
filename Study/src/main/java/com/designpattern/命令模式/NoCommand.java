package com.designpattern.命令模式;

/**
 * @ClassName NoCommand
 * @Description
 * @Author wzj
 * @Date 2020/8/6 17:40
 **/
// 没有任何命令，即空执行，用于初始化按钮，当调用空命令时，对象什么都不做
    // 这也是一种设计模式，省去对空的判断
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
