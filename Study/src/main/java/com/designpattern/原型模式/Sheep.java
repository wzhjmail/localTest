package com.designpattern.原型模式;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Sheep
 * @Description
 * @Author wzj
 * @Date 2020/10/13 15:16
 **/
@Data
@AllArgsConstructor
public class Sheep implements  Cloneable{

    private String name;
    private int age;
    private String color;

    // 克隆该实例，使用默认的clone方法来完成
    @Override
    protected Object clone() {
        Sheep sheep = null;
        try{
            sheep = (Sheep)super.clone();
        }catch (Exception e){
      System.out.println(e.getMessage());
        }

        return sheep;
    }
}
