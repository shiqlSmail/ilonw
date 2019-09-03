package com.ilonw.api.enums;

public enum UserStateEnum {
    NORMAL("NORMAL", "普通用户"),
    VIP("VIP", "VIP");

    private String code;

    private String desc;

    UserStateEnum() {
    }

    UserStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
