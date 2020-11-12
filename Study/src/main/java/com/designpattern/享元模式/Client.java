package com.designpattern.享元模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/8/7 10:43
 * 享元模式：系统中有大量对象，这些对象消耗大量内存，并且对象的状态大部分可以外部化时，可以采用享元模式
 * 用唯一的标示码判断，如果在内存中，返回标示的对象，用hashmap存储
 * 外部状态具有固化特性，不应该随着内部状态的改变而改变
 **/

public class Client {
  public static void main(String[] args) {
    //创建一个工厂类
    WebSiteFactory factory = new WebSiteFactory();

    //客户要一个以新闻形式发布的网站
    WebSite webSite1 = factory.getWebSiteCategory("新闻");
    webSite1.use(new User("waj"));

    //客户要一个以博客形式发布的网站
    WebSite webSite2 = factory.getWebSiteCategory("博客");
    webSite2.use(new User("jj"));

    //客户要一个以博客形式发布的网站
    WebSite webSite3 = factory.getWebSiteCategory("博客");
    webSite3.use(new User("ooo"));

    System.out.println("网站的分类共="+factory.getWebSiteCount());
  }
}
