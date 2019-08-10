package com.ilonw.api.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 忘记密码
 */
public class ForgetPassParam {
    @ApiModelProperty(value = "用户密码")
    private String ilonwUserPassword;

    @ApiModelProperty(value = "用户手机号码")
    private String ilonwUserPhone;

    public String getIlonwUserPassword() {
        return ilonwUserPassword;
    }

    public void setIlonwUserPassword(String ilonwUserPassword) {
        this.ilonwUserPassword = ilonwUserPassword;
    }

    public String getIlonwUserPhone() {
        return ilonwUserPhone;
    }

    public void setIlonwUserPhone(String ilonwUserPhone) {
        this.ilonwUserPhone = ilonwUserPhone;
    }
}
