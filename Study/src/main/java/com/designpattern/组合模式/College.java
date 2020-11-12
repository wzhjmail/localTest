package com.designpattern.组合模式;

import java.util.ArrayList;
import java.util.List;

/** @ClassName College @Description @Author wzj @Date 2020/10/16 17:19 */
public class College extends OrganizationComponent {

  // List中存放的是Department
  List<OrganizationComponent> componentList = new ArrayList<>();

  public College(String name, String des) {
    super(name, des);
  }

  public void add(OrganizationComponent organizationComponent) {
    componentList.add(organizationComponent);
  }

  public void remove(OrganizationComponent organizationComponent) {
    componentList.remove(organizationComponent);
  }

  // 输出College 包含系
  @Override
  public void print() {
    System.out.println("==========" + getName() + "==========");
    for (OrganizationComponent component : componentList) {
      component.print();
    }
  }

}
