package com.ilonw.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

public class IlonwLoginParam  implements Serializable {
    private static final long serialVersionUID = 1L;

    //private String ilonwUserCode;

    @ApiModelProperty(value = "手机号码")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String ilonwUserPhone;

    //private String ilonwUserEmail;

    private String ilonwUserPassword;

    private String ilonwSmsCode;

    //登录类型  （1：手机号验证码  2：账号密码）
    private Integer loginType;


    public String getIlonwSmsCode() {
        return ilonwSmsCode;
    }

    public void setIlonwSmsCode(String ilonwSmsCode) {
        this.ilonwSmsCode = ilonwSmsCode;
    }

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

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }
}
