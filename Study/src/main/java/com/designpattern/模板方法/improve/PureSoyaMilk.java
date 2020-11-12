package com.designpattern.模板方法.improve;

/**
 * @ClassName PureSoyaMilk
 * @Description
 * @Author wzj
 * @Date 2020/8/6 16:49
 **/

public class PureSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        // 空实现
    }

    // 钩子方法，如果某些类不需要第二步，这里控制第二步是否执行
    @Override
    boolean customerWantCondiments(){
        return false;
    }
}
