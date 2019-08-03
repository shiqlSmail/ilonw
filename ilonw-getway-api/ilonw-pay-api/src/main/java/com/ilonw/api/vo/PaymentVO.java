package com.ilonw.api.vo;

import java.io.Serializable;

public class PaymentVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String orderNumber;
    private String payType;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}

