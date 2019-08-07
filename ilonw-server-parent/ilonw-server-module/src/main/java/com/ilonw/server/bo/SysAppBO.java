package com.ilonw.server.bo;

import java.io.Serializable;

public class SysAppBO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String appChannel;
    private Integer appId;
    private String appKey;
    private String appCreatetime;
    private String appChannelName;
    private Integer appStatus;
    private String ilonwUserId;

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppCreatetime() {
        return appCreatetime;
    }

    public void setAppCreatetime(String appCreatetime) {
        this.appCreatetime = appCreatetime;
    }

    public String getAppChannelName() {
        return appChannelName;
    }

    public void setAppChannelName(String appChannelName) {
        this.appChannelName = appChannelName;
    }

    public Integer getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Integer appStatus) {
        this.appStatus = appStatus;
    }

    public String getIlonwUserId() {
        return ilonwUserId;
    }

    public void setIlonwUserId(String ilonwUserId) {
        this.ilonwUserId = ilonwUserId;
    }
}
