package com.ilonw.manager.domain;

import java.io.Serializable;

public class SysDeptBO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer deptId;

    private String deptName;

    private String deptCode;

    private String deptCreatetime;

    private String deptUpdatetime;

    private Integer deptStatus;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptCreatetime() {
        return deptCreatetime;
    }

    public void setDeptCreatetime(String deptCreatetime) {
        this.deptCreatetime = deptCreatetime == null ? null : deptCreatetime.trim();
    }

    public String getDeptUpdatetime() {
        return deptUpdatetime;
    }

    public void setDeptUpdatetime(String deptUpdatetime) {
        this.deptUpdatetime = deptUpdatetime == null ? null : deptUpdatetime.trim();
    }

    public Integer getDeptStatus() {
        return deptStatus;
    }

    public void setDeptStatus(Integer deptStatus) {
        this.deptStatus = deptStatus;
    }
}