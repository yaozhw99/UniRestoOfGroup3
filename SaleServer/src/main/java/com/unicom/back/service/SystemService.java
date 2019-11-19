package com.unicom.back.service;

import com.unicom.back.dao.SysUserDao;
import com.unicom.back.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    @Autowired
    private SysUserDao sysUserDao;

    public SysUser getUser(String operNo) {
        return sysUserDao.findByOperNo(operNo);
    }



}
