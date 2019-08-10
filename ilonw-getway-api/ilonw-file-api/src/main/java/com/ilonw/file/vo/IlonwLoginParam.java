package com.ilonw.file.vo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class IlonwLoginParam implements Serializable {
    private static final long serialVersionUID = 1L;

    //private String ilonwUserCode;

    @ApiModelProperty(value = "手机号码")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String ilonwUserPhone;

    private String ilonwUserPassword;


    public String getIlonwUserPhone() {
        return ilonwUserPhone;
    }

    public void setIlonwUserPhone(String ilonwUserPhone) {
        this.ilonwUserPhone = ilonwUserPhone;
    }

    public String getIlonwUserPassword() {
        return ilonwUserPassword;
    }

    public void setIlonwUserPassword(String ilonwUserPassword) {
        this.ilonwUserPassword = ilonwUserPassword;
    }
}
