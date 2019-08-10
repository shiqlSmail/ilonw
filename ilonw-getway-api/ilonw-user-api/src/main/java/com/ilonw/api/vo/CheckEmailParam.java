package com.ilonw.api.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 检查手机号码是否存在
 */
public class CheckEmailParam {
    @ApiModelProperty(value = "用户邮箱账号")
    private String ilonwUserEmail;

    public String getIlonwUserEmail() {
        return ilonwUserEmail;
    }

    public void setIlonwUserEmail(String ilonwUserEmail) {
        this.ilonwUserEmail = ilonwUserEmail;
    }
}
