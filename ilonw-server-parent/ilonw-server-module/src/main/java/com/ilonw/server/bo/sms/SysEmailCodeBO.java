package com.ilonw.server.bo.sms;

import java.io.Serializable;

public class SysEmailCodeBO implements Serializable {
    private static final long serialVersionUID = 1L;

    //验证码ID
    private String emailId;

    //验证码code
    private Integer emailCode;

    //验证码状态
    private Integer emailStatus;

    //验证码创建时间
    private String emailCreatetime;

    //手机号码
    private String emailName;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(Integer emailCode) {
        this.emailCode = emailCode;
    }

    public Integer getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Integer emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getEmailCreatetime() {
        return emailCreatetime;
    }

    public void setEmailCreatetime(String emailCreatetime) {
        this.emailCreatetime = emailCreatetime;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }
}