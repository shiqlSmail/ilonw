package com.ilonw.api.vo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class SysAppParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户平台名称")
    private String appChannelName;

    @ApiModelProperty(value = "客户在ilonw系统中的用户标识")
    private String appUserId;

    public String getAppChannelName() {
        return appChannelName;
    }

    public void setAppChannelName(String appChannelName) {
        this.appChannelName = appChannelName;
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }
}
