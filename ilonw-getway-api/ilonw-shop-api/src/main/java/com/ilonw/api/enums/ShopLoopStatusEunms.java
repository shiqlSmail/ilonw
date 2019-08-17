package com.ilonw.api.enums;

public enum ShopLoopStatusEunms {
    NORMAL("NORMAL","正常"),
    NO_NORMAL("NO_NORMAL","不正常"),
    ;

    private String resCode;
    private String resMsg;

    private ShopLoopStatusEunms() {
    }
    private ShopLoopStatusEunms(String resCode, String resMsg) {
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
