package com.ilonw.server.bo.sms;

import java.io.Serializable;

public class SysSmsBO implements Serializable {
    private static final long serialVersionUID = 1L;

    //验证码ID
    private String smsId;

    //验证码code
    private Integer smsCode;

    //验证码状态
    private Integer smsStatus;

    //验证码创建时间
    private String smsCreatetime;

    //手机号码
    private String smsPhone;

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public Integer getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(Integer smsCode) {
        this.smsCode = smsCode;
    }

    public Integer getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(Integer smsStatus) {
        this.smsStatus = smsStatus;
    }

    public String getSmsCreatetime() {
        return smsCreatetime;
    }

    public void setSmsCreatetime(String smsCreatetime) {
        this.smsCreatetime = smsCreatetime;
    }

    public String getSmsPhone() {
        return smsPhone;
    }

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone;
    }
}