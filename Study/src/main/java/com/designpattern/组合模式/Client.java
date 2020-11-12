package com.designpattern.组合模式;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/16 15:55
 **/

public class Client {
  public static void main(String[] args) {
    //从大到小创建对象 学校
      University university = new University("清华大学", "中国最好的大学");

      //创建 学院
      College computerCollege = new College("计算机学院", "计算机学院描述");
      College messageCollege = new College("信息工程学院", "信息工程学院描述");

      //创建各个学院下面的系 专业
      computerCollege.add(new Department("软件工程", "软件工程不错"));
      computerCollege.add(new Department("网络工程", "网络工程不错"));
      computerCollege.add(new Department("计算机科学与技术", "计算机科学与技术是老牌专业"));

      messageCollege.add(new Department("通信工程", "通信工程不好学"));
      messageCollege.add(new Department("信息工程", "信息工程好学"));

      //将学院加入到学校中
      university.add(computerCollege);
      university.add(messageCollege);

      university.print();
  }
}
