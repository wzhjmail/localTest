package com.entity;

import com.common.checkparameter.IntLongNotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Apple
 * @Description
 * @Author wzj
 * @Date 2020/8/5 14:52
 **/
@Data
public class Apple {

    private String color;
    @IntLongNotNull
    private int price;

    private Fruit fruit;

  public static void main(String[] args) {

      Apple a1 = new Apple();
      a1.price=11;
      Apple a2 = new Apple();
      a2.price=12;
      Apple a3 = new Apple();
      a3.price=13;

      List<Apple> appleList = new ArrayList<>();
      appleList.add(a1);
      appleList.add(a2);
      appleList.add(a3);

      appleList = appleList.stream().sorted(Comparator.comparing(Apple::getPrice).reversed())
              .collect(Collectors.toList());
    System.out.println(appleList);
  }
}
