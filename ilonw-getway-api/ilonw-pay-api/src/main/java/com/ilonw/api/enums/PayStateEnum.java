package com.ilonw.api.enums;

public enum PayStateEnum {
    CREATE("CREATE", "创建支付订单"),
    SUCCESS("SUCCESS", "支付成功"),
    FAIL("FAIL", "支付失败"),
    CANCEL("CANCEL", "用户取消");

    private String code;

    private String desc;

    PayStateEnum() {
    }

    PayStateEnum(String code, String desc) {
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
