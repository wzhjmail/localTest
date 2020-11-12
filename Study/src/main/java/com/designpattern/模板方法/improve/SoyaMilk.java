package com.designpattern.模板方法.improve;

/**
 * @ClassName SoyaMilk
 * @Description
 * @Author wzj
 * @Date 2020/8/6 16:29
 **/

//抽象类 表示豆浆
public abstract class SoyaMilk {

    // 模板方法, 可以用final，不让子类覆盖
    final void make(){
        select();
        // 钩子方法，如果某些类不需要第二步，这里控制第二步是否执行
        if(customerWantCondiments()){
            addCondiments();
        }
        soak();
        beat();
    }

    // 选材料
    void select() {
    System.out.println("第一步: 选择好的新鲜黄豆");
    }

    // 添加不同的配料，抽象方法，子类具体实现
    abstract void addCondiments();

    // 浸泡
    void soak(){
    System.out.println("第三步：黄豆和配料开始浸泡，需要三小时");
    }

    void beat(){
    System.out.println("第四步：黄豆和配料放到豆浆机去打碎");
    }

    // 钩子方法，如果某些类不需要第二步，这里控制第二步是否执行
    boolean customerWantCondiments(){
        return true;
    }
}
