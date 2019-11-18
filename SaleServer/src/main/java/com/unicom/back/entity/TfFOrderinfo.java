package com.unicom.back.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TfFOrderinfo {
    private int orderId;
    private int userId;
    private int state;
    //输入参数格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "orderId:" + orderId +
                ", userId:" + userId +
                ", state:" + state +
                ", updateTime:" + updateTime +
                '}';
    }
}
