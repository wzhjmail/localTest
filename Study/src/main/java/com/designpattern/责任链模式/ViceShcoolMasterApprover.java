package com.designpattern.责任链模式;

/**
 * @ClassName ViceShcoolMasterApprover
 * @Description
 * @Author wzj
 * @Date 2020/10/10 11:35
 **/

public class ViceShcoolMasterApprover extends Approver{
    public ViceShcoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if(purchaseRequest.getPrice() > 10000 &&
                purchaseRequest.getPrice()<=30000){
            System.out.println("请求编号 ID= " + purchaseRequest.getId()
                    + " 被 " + this.name + " 处理");
        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
