package com.ilonw.manager.domain;

import java.io.Serializable;

public class SysPositionBO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer positionId;

    private String positionCode;

    private String positionName;

    private String positionCreatetime;

    private String positionUpdatetime;

    private Integer positionStatus;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode == null ? null : positionCode.trim();
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public String getPositionCreatetime() {
        return positionCreatetime;
    }

    public void setPositionCreatetime(String positionCreatetime) {
        this.positionCreatetime = positionCreatetime == null ? null : positionCreatetime.trim();
    }

    public String getPositionUpdatetime() {
        return positionUpdatetime;
    }

    public void setPositionUpdatetime(String positionUpdatetime) {
        this.positionUpdatetime = positionUpdatetime == null ? null : positionUpdatetime.trim();
    }

    public Integer getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(Integer positionStatus) {
        this.positionStatus = positionStatus;
    }
}