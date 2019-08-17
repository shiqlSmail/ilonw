package com.ilonw.server.bo.user;

import java.io.Serializable;
import java.util.Date;

public class IlonwUserBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ilonwUserId;

    private String ilonwUserCode;

    private String ilonwUserNikename;

    private String ilonwUserName;

    private Integer ilonwUserSex;

    private Integer ilonwUserAge;

    private String ilonwUserBrithday;

    private Date ilonwUserCreatetime;

    private Integer ilonwUserStatus;

    private String ilonwUserAddress;

    private String ilonwUserIp ;

    private String ilonwUserImage;

    private String ilonwUserPhone;

    private String ilonwUserEmail;

    private String ilonwUserPassword;


    public String getIlonwUserId() {
        return ilonwUserId;
    }

    public void setIlonwUserId(String ilonwUserId) {
        this.ilonwUserId = ilonwUserId;
    }

    public String getIlonwUserCode() {
        return ilonwUserCode;
    }

    public void setIlonwUserCode(String ilonwUserCode) {
        this.ilonwUserCode = ilonwUserCode;
    }

    public String getIlonwUserNikename() {
        return ilonwUserNikename;
    }

    public void setIlonwUserNikename(String ilonwUserNikename) {
        this.ilonwUserNikename = ilonwUserNikename;
    }

    public String getIlonwUserName() {
        return ilonwUserName;
    }

    public void setIlonwUserName(String ilonwUserName) {
        this.ilonwUserName = ilonwUserName;
    }

    public Integer getIlonwUserSex() {
        return ilonwUserSex;
    }

    public void setIlonwUserSex(Integer ilonwUserSex) {
        this.ilonwUserSex = ilonwUserSex;
    }

    public Integer getIlonwUserAge() {
        return ilonwUserAge;
    }

    public void setIlonwUserAge(Integer ilonwUserAge) {
        this.ilonwUserAge = ilonwUserAge;
    }

    public String getIlonwUserBrithday() {
        return ilonwUserBrithday;
    }

    public void setIlonwUserBrithday(String ilonwUserBrithday) {
        this.ilonwUserBrithday = ilonwUserBrithday;
    }

    public Date getIlonwUserCreatetime() {
        return ilonwUserCreatetime;
    }

    public void setIlonwUserCreatetime(Date ilonwUserCreatetime) {
        this.ilonwUserCreatetime = ilonwUserCreatetime;
    }

    public Integer getIlonwUserStatus() {
        return ilonwUserStatus;
    }

    public void setIlonwUserStatus(Integer ilonwUserStatus) {
        this.ilonwUserStatus = ilonwUserStatus;
    }

    public String getIlonwUserAddress() {
        return ilonwUserAddress;
    }

    public void setIlonwUserAddress(String ilonwUserAddress) {
        this.ilonwUserAddress = ilonwUserAddress;
    }

    public String getIlonwUserIp() {
        return ilonwUserIp;
    }

    public void setIlonwUserIp(String ilonwUserIp) {
        this.ilonwUserIp = ilonwUserIp;
    }

    public String getIlonwUserImage() {
        return ilonwUserImage;
    }

    public void setIlonwUserImage(String ilonwUserImage) {
        this.ilonwUserImage = ilonwUserImage;
    }

    public String getIlonwUserPhone() {
        return ilonwUserPhone;
    }

    public void setIlonwUserPhone(String ilonwUserPhone) {
        this.ilonwUserPhone = ilonwUserPhone;
    }

    public String getIlonwUserEmail() {
        return ilonwUserEmail;
    }

    public void setIlonwUserEmail(String ilonwUserEmail) {
        this.ilonwUserEmail = ilonwUserEmail;
    }

    public String getIlonwUserPassword() {
        return ilonwUserPassword;
    }

    public void setIlonwUserPassword(String ilonwUserPassword) {
        this.ilonwUserPassword = ilonwUserPassword;
    }

    @Override
    public String toString() {
        return "SysIlonwUserEntity{" +
                "ilonwUserId='" + ilonwUserId + '\'' +
                ", ilonwUserCode='" + ilonwUserCode + '\'' +
                ", ilonwUserNikename='" + ilonwUserNikename + '\'' +
                ", ilonwUserName='" + ilonwUserName + '\'' +
                ", ilonwUserSex='" + ilonwUserSex + '\'' +
                ", ilonwUserAge='" + ilonwUserAge + '\'' +
                ", ilonwUserBrithday='" + ilonwUserBrithday + '\'' +
                ", ilonwUserCreatetime='" + ilonwUserCreatetime + '\'' +
                ", ilonwUserStatus='" + ilonwUserStatus + '\'' +
                ", ilonwUserAddress='" + ilonwUserAddress + '\'' +
                ", ilonwUserIp='" + ilonwUserIp + '\'' +
                ", ilonwUserImage='" + ilonwUserImage + '\'' +
                ", ilonwUserPhone='" + ilonwUserPhone + '\'' +
                ", ilonwUserEmail='" + ilonwUserEmail + '\'' +
                ", ilonwUserPassword='" + ilonwUserPassword + '\'' +
                '}';
    }
}