package com.ilonw.api.enums;


public enum PayTypeEnum {
    WECHAT("WECHAT", "微信"),
    ALIPAY("ALIPAY", "支付宝");

    private String code;

    private String desc;

    PayTypeEnum() {
    }

    PayTypeEnum(String code, String desc) {
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
