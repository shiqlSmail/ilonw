package com.ilonw.api.config;

public enum UserProperties {
    ADMIN("admin","admin",1),
    SHIQILONG("17621663876","shiqilong",1),
    ;

    private String username;
    private String password;
    private Integer status;

    private UserProperties() {
    }
    private UserProperties(String username, String password,Integer status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
