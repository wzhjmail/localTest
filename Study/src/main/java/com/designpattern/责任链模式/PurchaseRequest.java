package com.designpattern.责任链模式;

import lombok.Data;

/**
 * @ClassName PurchaseRequest
 * @Description
 * @Author wzj
 * @Date 2020/10/10 11:18
 **/
@Data
public class PurchaseRequest {

    private int type = 0;//请求类型

    private float price = 0.0f;//报销金额

    private int id = 0;

    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }
}
