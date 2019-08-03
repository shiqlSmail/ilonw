package com.ilonw.api.vo;

import javax.validation.constraints.NotBlank;

public class EmailSendParam {
    @NotBlank(message = "发件人邮箱不能为空")
    private String email;

    @NotBlank(message = "邮箱URL不能为空")
    private String url;

    @NotBlank(message = "发件人姓名不能为空")
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
