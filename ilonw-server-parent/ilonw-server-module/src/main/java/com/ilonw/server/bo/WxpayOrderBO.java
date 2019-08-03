package com.ilonw.server.bo;

import java.io.Serializable;
import java.util.Date;

public class WxpayOrderBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String wxpayOrderId;

    private String nonceStr;

    private String outTradeNo;

    private Integer totalFee;

    private String spbillCreateIp;

    private Date wxpayCreatetime;

    private Date wxpayUpdatetime;

    private String prepayId;

    private String returnCode;

    private String resultCode;

    private String returnMsg;

    private String errCode;

    private String errCodeDes;

    public String getWxpayOrderId() {
        return wxpayOrderId;
    }

    public void setWxpayOrderId(String wxpayOrderId) {
        this.wxpayOrderId = wxpayOrderId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public Date getWxpayCreatetime() {
        return wxpayCreatetime;
    }

    public void setWxpayCreatetime(Date wxpayCreatetime) {
        this.wxpayCreatetime = wxpayCreatetime;
    }

    public Date getWxpayUpdatetime() {
        return wxpayUpdatetime;
    }

    public void setWxpayUpdatetime(Date wxpayUpdatetime) {
        this.wxpayUpdatetime = wxpayUpdatetime;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }
}
