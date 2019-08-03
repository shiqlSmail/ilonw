package com.ilonw.server.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderinfoBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 支付金额
     */
    private BigDecimal money;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * 支付状态
     */
    private String payState;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }
}
