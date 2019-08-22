package com.ilonw.manager.domain;

import java.io.Serializable;

public class SysRoleBO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer roleId;

    private String roleCode;

    private String roleName;

    private String roleCreatetime;

    private String roleUpdatetime;

    private Integer roleStatus;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCreatetime() {
        return roleCreatetime;
    }

    public void setRoleCreatetime(String roleCreatetime) {
        this.roleCreatetime = roleCreatetime == null ? null : roleCreatetime.trim();
    }

    public String getRoleUpdatetime() {
        return roleUpdatetime;
    }

    public void setRoleUpdatetime(String roleUpdatetime) {
        this.roleUpdatetime = roleUpdatetime == null ? null : roleUpdatetime.trim();
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }
}