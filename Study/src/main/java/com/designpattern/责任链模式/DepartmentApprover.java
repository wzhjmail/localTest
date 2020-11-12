package com.designpattern.责任链模式;

/**
 * @ClassName DepartmentApprover
 * @Description
 * @Author wzj
 * @Date 2020/10/10 11:30
 **/

public class DepartmentApprover extends Approver {


    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice()<=5000){
      System.out.println("请求编号 ID= " + purchaseRequest.getId()
              + " 被 " + this.name + " 处理");
        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
