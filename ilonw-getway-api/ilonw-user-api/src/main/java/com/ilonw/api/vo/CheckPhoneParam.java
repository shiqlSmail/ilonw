package com.ilonw.api.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 检查手机号码是否存在
 */
public class CheckPhoneParam {
    @ApiModelProperty(value = "用户手机号码")
    private String ilonwUserPhone;

    public String getIlonwUserPhone() {
        return ilonwUserPhone;
    }

    public void setIlonwUserPhone(String ilonwUserPhone) {
        this.ilonwUserPhone = ilonwUserPhone;
    }
}
