package com.ilonw.manager.domain;

import java.io.Serializable;

public class SysLoginBO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer loginId;

    private Integer loginCode;

    private String loginIp;

    private String loginUsername;

    private String loginAddress;

    private Integer loginStatus;

    private String loginTime;

    private String loginRole;

    private String roleName;

    public Integer getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(Integer loginCode) {
        this.loginCode = loginCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername == null ? null : loginUsername.trim();
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime == null ? null : loginTime.trim();
    }

    public String getLoginRole() {
        return loginRole;
    }

    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole == null ? null : loginRole.trim();
    }
}