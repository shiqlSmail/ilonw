package com.ilonw.api.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 检查手机号码是否存在
 */
public class CheckPhoneSmsParam {
    @ApiModelProperty(value = "用户手机号码")
    private String ilonwUserPhone;

    @ApiModelProperty(value = "验证码")
    private String smscode;


    public String getIlonwUserPhone() {
        return ilonwUserPhone;
    }

    public void setIlonwUserPhone(String ilonwUserPhone) {
        this.ilonwUserPhone = ilonwUserPhone;
    }

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode;
    }
}
