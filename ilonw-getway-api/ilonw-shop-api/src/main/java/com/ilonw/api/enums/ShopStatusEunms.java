package com.ilonw.api.enums;

public enum ShopStatusEunms {
    UPPERSHELF("UPPERSHELF","上架"),
    LOWERSHELF("LOWERSHELF","下架"),
    //PHONE_NOTNULL("100001","第三方登录");
    ;

    private String resCode;
    private String resMsg;

    private ShopStatusEunms() {
    }
    private ShopStatusEunms(String resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
