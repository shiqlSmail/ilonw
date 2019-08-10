package com.ilonw.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysIlonwSaveUserParam", description = "ilonw注册用户表信息")
public class SysIlonwSaveUserParam {

    @ApiModelProperty(value = "用户昵称")
    private String ilonwUserNikename;

    @ApiModelProperty(value = "用户姓名")
    private String ilonwUserName;

    @ApiModelProperty(value = "用户性别")
    private Integer ilonwUserSex;

    @ApiModelProperty(value = "用户年龄")
    private Integer ilonwUserAge;

    @ApiModelProperty(value = "用户生日")
    private String ilonwUserBrithday;

    @ApiModelProperty(value = "用户地址")
    private String ilonwUserAddress;

    @ApiModelProperty(value = "用户头像")
    private String ilonwUserImage;

    @ApiModelProperty(value = "用户手机号码")
    private String ilonwUserPhone;

    @ApiModelProperty(value = "用户邮箱")
    private String ilonwUserEmail;

    @ApiModelProperty(value = "用户登陆密码")
    private String ilonwUserPassword;

    @ApiModelProperty(value = "验证码")
    private String smscode;

    private String ilonwUserIp;

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

    public String getIlonwUserAddress() {
        return ilonwUserAddress;
    }

    public void setIlonwUserAddress(String ilonwUserAddress) {
        this.ilonwUserAddress = ilonwUserAddress;
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

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode;
    }

    public String getIlonwUserIp() {
        return ilonwUserIp;
    }

    public void setIlonwUserIp(String ilonwUserIp) {
        this.ilonwUserIp = ilonwUserIp;
    }
}
