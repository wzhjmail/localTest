package com.designpattern.享元模式;

/**
 * @ClassName ConcreteWebSite
 * @Description
 * @Author wzj
 * @Date 2020/8/7 10:36
 **/

public class ConcreteWebSite extends WebSite{
    //共享的部分，内部状态
    private String type="";//网站发布的形式类型

    public ConcreteWebSite(String type){
        this.type=type;
    }

    // user时外部状态
    @Override
    public void use(User user) {
    System.out.println("网站的发布形式为:"+type+"；；；   "+user.getName()+"在使用中。。。");
    }
}
