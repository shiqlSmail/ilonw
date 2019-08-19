package com.ilonw.manager.domain;

import java.io.Serializable;

public class SysAdminBO   implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer adminId;

    private Integer adminCode;
    private String adminUsername;

    private String adminSex;

    private Integer adminAge;

    private String adminDept;

    private String adminPosition;

    private String adminPhone;

    private String adminEmail;

    private String adminRole;

    private String adminRemark;

    private String adminImg;

    private String adminPassword;

    private String adminCreatetime;

    private String adminUpdatetime;

    public Integer getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(Integer adminCode) {
        this.adminCode = adminCode;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername == null ? null : adminUsername.trim();
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex == null ? null : adminSex.trim();
    }

    public Integer getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(Integer adminAge) {
        this.adminAge = adminAge;
    }

    public String getAdminDept() {
        return adminDept;
    }

    public void setAdminDept(String adminDept) {
        this.adminDept = adminDept == null ? null : adminDept.trim();
    }

    public String getAdminPosition() {
        return adminPosition;
    }

    public void setAdminPosition(String adminPosition) {
        this.adminPosition = adminPosition == null ? null : adminPosition.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole == null ? null : adminRole.trim();
    }

    public String getAdminRemark() {
        return adminRemark;
    }

    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark == null ? null : adminRemark.trim();
    }

    public String getAdminImg() {
        return adminImg;
    }

    public void setAdminImg(String adminImg) {
        this.adminImg = adminImg == null ? null : adminImg.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminCreatetime() {
        return adminCreatetime;
    }

    public void setAdminCreatetime(String adminCreatetime) {
        this.adminCreatetime = adminCreatetime == null ? null : adminCreatetime.trim();
    }

    public String getAdminUpdatetime() {
        return adminUpdatetime;
    }

    public void setAdminUpdatetime(String adminUpdatetime) {
        this.adminUpdatetime = adminUpdatetime == null ? null : adminUpdatetime.trim();
    }
}