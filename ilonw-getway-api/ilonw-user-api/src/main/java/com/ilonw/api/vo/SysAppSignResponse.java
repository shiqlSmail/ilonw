package com.ilonw.api.vo;

public class SysAppSignResponse {

    private Integer app_id;

    private String app_key;

    private String app_private_key;

    private String app_public_key;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getApp_private_key() {
        return app_private_key;
    }

    public void setApp_private_key(String app_private_key) {
        this.app_private_key = app_private_key;
    }

    public String getApp_public_key() {
        return app_public_key;
    }

    public void setApp_public_key(String app_public_key) {
        this.app_public_key = app_public_key;
    }
}
