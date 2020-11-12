package com.designpattern.责任链模式;

/**
 * @ClassName Approver
 * @Description
 * @Author wzj
 * @Date 2020/10/10 11:21
 **/

public abstract class Approver {

    Approver approver;//下一个处理者

    String name;//名字

    public Approver(String name) {
        this.name = name;
    }

    // 下一个处理者
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    //处理审批请求的方法，得到一个请求，处理是子类完成的，因此该方法做成抽象的
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
