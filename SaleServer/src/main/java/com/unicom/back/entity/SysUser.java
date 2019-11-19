package com.unicom.back.entity;

public class SysUser {
    private String operNo;
    private String password;

    public String getOperNo() {
        return operNo;
    }

    public void setOperNo(String operNo) {
        this.operNo = operNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SysUser(String operNo, String password) {
        this.operNo = operNo;
        this.password = password;
    }
}
