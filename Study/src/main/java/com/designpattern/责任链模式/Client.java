package com.designpattern.责任链模式;

import java.text.SimpleDateFormat;

/**
 * @ClassName Client
 * @Description
 * @Author wzj
 * @Date 2020/10/10 10:55
 **/

public class Client {

  public static void main(String[] args) {


    SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
    String s = sdf.format(1602345600*1000L);
    System.out.println(s);

    //创建一个请求
    PurchaseRequest purchaseRequest = new PurchaseRequest(1,21000,1);

    //创建相关的审批人
    DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
    CollegeApprover collegeApprover = new CollegeApprover("李院长");
    ViceShcoolMasterApprover viceShcoolMasterApprover = new ViceShcoolMasterApprover("王副校长");
    SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("同校长");

    //将各个审批级别的下一个设置好(处理人构成环形)
    departmentApprover.setApprover(collegeApprover);
    collegeApprover.setApprover(viceShcoolMasterApprover);
    viceShcoolMasterApprover.setApprover(schoolMasterApprover);
    schoolMasterApprover.setApprover(departmentApprover);

    departmentApprover.processRequest(purchaseRequest);

  }
}
