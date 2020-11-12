package com.designpattern.组合模式;

import java.util.ArrayList;
import java.util.List;

/** @ClassName University @Description @Author wzj @Date 2020/10/16 16:25 */
// university 就是 composite, 可以管理College
public class University extends OrganizationComponent {

  List<OrganizationComponent> componentList = new ArrayList<>();

  // 构造器
  public University(String name, String des) {
    super(name, des);
  }

  public void add(OrganizationComponent organizationComponent) {
    componentList.add(organizationComponent);
  }

  public void remove(OrganizationComponent organizationComponent) {
    componentList.remove(organizationComponent);
  }

  // 输出University 包含学院
  @Override
  public void print() {
    System.out.println("==========" + getName() + "==========");
    for (OrganizationComponent component : componentList) {
      component.print();
    }
  }
}
