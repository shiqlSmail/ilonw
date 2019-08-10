package com.server.tools.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class APIBaseResult {
    protected String respCode;
    protected String respMessage;
    private Object respData;
    private Integer smscode;
    private Long totalCount;
    private BigDecimal rechargeTotalAmount;
    private BigDecimal payTotalAmount;
    private String times;


    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }

    public Object getRespData() {
        return respData;
    }

    public void setRespData(Object respData) {
        this.respData = respData;
    }

    public Integer getSmscode() {
        return smscode;
    }

    public void setSmscode(Integer smscode) {
        this.smscode = smscode;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getRechargeTotalAmount() {
        return rechargeTotalAmount;
    }

    public void setRechargeTotalAmount(BigDecimal rechargeTotalAmount) {
        this.rechargeTotalAmount = rechargeTotalAmount;
    }

    public BigDecimal getPayTotalAmount() {
        return payTotalAmount;
    }

    public void setPayTotalAmount(BigDecimal payTotalAmount) {
        this.payTotalAmount = payTotalAmount;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public static void setSourceMissErrResult(APIBaseResult sourceMissErrResult) {
        APIBaseResult.sourceMissErrResult = sourceMissErrResult;
    }

    private static APIBaseResult sourceMissErrResult;
    public static APIBaseResult buildErrorResult(String errorDescription) {
        APIBaseResult apiBaseResult = new APIBaseResult();
        SetAPIResultUtil.setFail(apiBaseResult);
        apiBaseResult.setRespData("");
        return apiBaseResult;
    }
    public static APIBaseResult getSourceMissErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setRespData("");
        }
        return sourceMissErrResult;
    }
    public static APIBaseResult getSourceInValidErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setRespData("");
        }
        return sourceMissErrResult;
    }
    public static APIBaseResult getMissVersionErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setRespData("");
        }
        return sourceMissErrResult;
    }
}
