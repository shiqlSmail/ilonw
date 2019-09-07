package com.ilonw.server.bo.shop;

import java.io.Serializable;
import java.util.Date;

public class SmsHomeAdvertise implements Serializable {
    private Long id;

    private String name;

    // 轮播位置：0->PC首页轮播；1->app首页轮播
    private Integer type;

    private String pic;

    private Date startTime;

    private Date endTime;

    // 上下线状态：0->下线；1->上线
    private Integer status;

    // 点击数
    private Integer clickCount;

    // 下单数
    private Integer orderCount;

    // 链接地址
    private String url;

    // 备注
    private String note;

    // 排序
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SmsHomeAdvertise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", pic='" + pic + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", clickCount=" + clickCount +
                ", orderCount=" + orderCount +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", sort=" + sort +
                '}';
    }
}