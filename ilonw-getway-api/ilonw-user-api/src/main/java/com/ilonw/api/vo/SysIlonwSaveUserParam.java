package com.ilonw.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysIlonwSaveUserParam", description = "ilonw注册用户表信息")
public class SysIlonwSaveUserParam {


    @ApiModelProperty(value = "用户昵称")
    private String ilonw_user_nikename;

    @ApiModelProperty(value = "用户姓名")
    private String ilonw_user_name;

    @ApiModelProperty(value = "用户性别")
    private Integer ilonw_user_sex;

    @ApiModelProperty(value = "用户年龄")
    private Integer ilonw_user_age;

    @ApiModelProperty(value = "用户生日")
    private String ilonw_user_brithday;

    @ApiModelProperty(value = "用户地址")
    private String ilonw_user_address;

    @ApiModelProperty(value = "用户头像")
    private String ilonw_user_image;

    @ApiModelProperty(value = "用户手机号码")
    private String ilonw_user_phone;

    @ApiModelProperty(value = "用户邮箱")
    private String ilonw_user_email;

    @ApiModelProperty(value = "用户登陆密码")
    private String ilonwUserPassword;

    @ApiModelProperty(value = "验证码")
    private String smscode;


    public String getIlonw_user_nikename() {
        return ilonw_user_nikename;
    }

    public void setIlonw_user_nikename(String ilonw_user_nikename) {
        this.ilonw_user_nikename = ilonw_user_nikename;
    }

    public String getIlonw_user_name() {
        return ilonw_user_name;
    }

    public void setIlonw_user_name(String ilonw_user_name) {
        this.ilonw_user_name = ilonw_user_name;
    }

    public Integer getIlonw_user_sex() {
        return ilonw_user_sex;
    }

    public void setIlonw_user_sex(Integer ilonw_user_sex) {
        this.ilonw_user_sex = ilonw_user_sex;
    }

    public Integer getIlonw_user_age() {
        return ilonw_user_age;
    }

    public void setIlonw_user_age(Integer ilonw_user_age) {
        this.ilonw_user_age = ilonw_user_age;
    }

    public String getIlonw_user_brithday() {
        return ilonw_user_brithday;
    }

    public void setIlonw_user_brithday(String ilonw_user_brithday) {
        this.ilonw_user_brithday = ilonw_user_brithday;
    }

    public String getIlonw_user_address() {
        return ilonw_user_address;
    }

    public void setIlonw_user_address(String ilonw_user_address) {
        this.ilonw_user_address = ilonw_user_address;
    }

    public String getIlonw_user_image() {
        return ilonw_user_image;
    }

    public void setIlonw_user_image(String ilonw_user_image) {
        this.ilonw_user_image = ilonw_user_image;
    }

    public String getIlonw_user_phone() {
        return ilonw_user_phone;
    }

    public void setIlonw_user_phone(String ilonw_user_phone) {
        this.ilonw_user_phone = ilonw_user_phone;
    }

    public String getIlonw_user_email() {
        return ilonw_user_email;
    }

    public void setIlonw_user_email(String ilonw_user_email) {
        this.ilonw_user_email = ilonw_user_email;
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

    @Override
    public String toString() {
        return "SysIlonwSaveUserParam{" +
                "ilonw_user_nikename='" + ilonw_user_nikename + '\'' +
                ", ilonw_user_name='" + ilonw_user_name + '\'' +
                ", ilonw_user_sex=" + ilonw_user_sex +
                ", ilonw_user_age=" + ilonw_user_age +
                ", ilonw_user_brithday='" + ilonw_user_brithday + '\'' +
                ", ilonw_user_address='" + ilonw_user_address + '\'' +
                ", ilonw_user_image='" + ilonw_user_image + '\'' +
                ", ilonw_user_phone='" + ilonw_user_phone + '\'' +
                ", ilonw_user_email='" + ilonw_user_email + '\'' +
                ", ilonwUserPassword='" + ilonwUserPassword + '\'' +
                ", smscode='" + smscode + '\'' +
                '}';
    }
}
