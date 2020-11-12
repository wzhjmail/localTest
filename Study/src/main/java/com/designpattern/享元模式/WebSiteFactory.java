package com.designpattern.享元模式;

import java.util.HashMap;

/**
 * @ClassName WebSiteFactory
 * @Description
 * @Author wzj
 * @Date 2020/8/7 10:38
 **/
//根据需求防护一个网站
public class WebSiteFactory {

    //集合，充当池的作用
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    //根据网站的类型，返回一个网站，如果没有则创建一个网站，并放入到池中，并返回
    public WebSite getWebSiteCategory(String type) {
        if(!pool.containsKey(type)) {
            //创建一个网站，并放入池中
            pool.put(type, new ConcreteWebSite(type));
        }
        return (WebSite)pool.get(type);
    }

    // 获取网站分类的总数（池子中有多少个网站类型）
    public int getWebSiteCount() {
        return pool.size();
    }
}
