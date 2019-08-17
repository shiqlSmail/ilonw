package com.ilonw.server.bo.sys;

import java.io.Serializable;

public class SysIlonwLogsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //日志ID
    private String logId;

    //日志写入人
    private String logAuthor;

    //日志创建时间
    private String logCreatetime;

    //日志记录接口的状态
    private String logStatus;

    //接口返回结果
    private String logResult;

    //接口请求参数
    private String logParam;

    //接口请求路径
    private String logRequest;

    //接口耗时
    private String logTimes;

    //接口请求的IP
    private String logIp;

    //接口请求的类型
    private String logType;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogAuthor() {
        return logAuthor;
    }

    public void setLogAuthor(String logAuthor) {
        this.logAuthor = logAuthor;
    }

    public String getLogCreatetime() {
        return logCreatetime;
    }

    public void setLogCreatetime(String logCreatetime) {
        this.logCreatetime = logCreatetime;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    public String getLogParam() {
        return logParam;
    }

    public void setLogParam(String logParam) {
        this.logParam = logParam;
    }

    public String getLogRequest() {
        return logRequest;
    }

    public void setLogRequest(String logRequest) {
        this.logRequest = logRequest;
    }

    public String getLogTimes() {
        return logTimes;
    }

    public void setLogTimes(String logTimes) {
        this.logTimes = logTimes;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }
}