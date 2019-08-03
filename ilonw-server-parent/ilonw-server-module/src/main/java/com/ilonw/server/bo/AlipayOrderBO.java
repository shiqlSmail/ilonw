package com.ilonw.server.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AlipayOrderBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String alipayOrderId;

    private String outTradeNo;

    private BigDecimal totalAmount;

    private Date alipayCreatetime;

    private Date alipayUpdatetime;

    private String returnBody;

    private String userId;

    private String orderId;

    public String getAlipayOrderId() {
        return alipayOrderId;
    }

    public void setAlipayOrderId(String alipayOrderId) {
        this.alipayOrderId = alipayOrderId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getAlipayCreatetime() {
        return alipayCreatetime;
    }

    public void setAlipayCreatetime(Date alipayCreatetime) {
        this.alipayCreatetime = alipayCreatetime;
    }

    public Date getAlipayUpdatetime() {
        return alipayUpdatetime;
    }

    public void setAlipayUpdatetime(Date alipayUpdatetime) {
        this.alipayUpdatetime = alipayUpdatetime;
    }

    public String getReturnBody() {
        return returnBody;
    }

    public void setReturnBody(String returnBody) {
        this.returnBody = returnBody;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}