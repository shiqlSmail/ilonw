package com.server.tools.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class APIBaseResult {
    protected String errorCode;
    protected String message;
    private Object data;
    private Integer smscode;
    private Long totalCount;
    private BigDecimal rechargeTotalAmount;
    private BigDecimal payTotalAmount;
    private String times;
    
    
    public Integer getSmscode() {
		return smscode;
	}

	public void setSmscode(Integer smscode) {
		this.smscode = smscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
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

    private static APIBaseResult sourceMissErrResult;
    public static APIBaseResult buildErrorResult(String errorDescription) {
        APIBaseResult apiBaseResult = new APIBaseResult();
        SetAPIResultUtil.setFail(apiBaseResult);
        apiBaseResult.setData("");
        return apiBaseResult;
    }
    public static APIBaseResult getSourceMissErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setData("");
        }
        return sourceMissErrResult;
    }
    public static APIBaseResult getSourceInValidErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setData("");
        }
        return sourceMissErrResult;
    }
    public static APIBaseResult getMissVersionErrResult() {
        if (null == sourceMissErrResult) {
            sourceMissErrResult = new APIBaseResult();
            SetAPIResultUtil.setFail(sourceMissErrResult);
            sourceMissErrResult.setData("");
        }
        return sourceMissErrResult;
    }
}
