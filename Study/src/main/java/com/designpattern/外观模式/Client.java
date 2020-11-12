package com.designpattern.外观模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/8/7 11:37
 **/

public class Client {
  public static void main(String[] args) {
      HomeThreaterFacade homeThreaterFacade = new HomeThreaterFacade();
      homeThreaterFacade.ready();
      homeThreaterFacade.play();
      homeThreaterFacade.pause();
      homeThreaterFacade.end();

  }
}
