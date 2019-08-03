package com.ilonw.server.bo;

import java.io.Serializable;

public class SysEmailUrlBO implements Serializable {
    private static final long serialVersionUID = 1L;

    //验证码ID
    private String emailId;

    //验证码code
    private String emailUrl;

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

    public String getEmailUrl() {
        return emailUrl;
    }

    public void setEmailUrl(String emailUrl) {
        this.emailUrl = emailUrl;
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