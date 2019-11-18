package com.unicom.back.entity;


import java.util.Date;

public class TbLogOrder {
    private int id;
    private String serialNumber;
    private int userId;
    private int orderProductId;
    private int orderActionId;
    private Date orderTime;
    private String epcode;
    private String userName;
    private String psptId;
    private String postAddress;
    private String linkPhone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public int getOrderActionId() {
        return orderActionId;
    }

    public void setOrderActionId(int orderActionId) {
        this.orderActionId = orderActionId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getEpcode() {
        return epcode;
    }

    public void setEpcode(String epcode) {
        this.epcode = epcode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPsptId() {
        return psptId;
    }

    public void setPsptId(String psptId) {
        this.psptId = psptId;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }
}
