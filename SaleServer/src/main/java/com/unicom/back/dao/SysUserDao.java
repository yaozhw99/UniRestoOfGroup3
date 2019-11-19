package com.unicom.back.dao;

import com.unicom.back.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserDao {

    @Select("select * from sys_user where operNo=#{operNo}")
    public SysUser findByOperNo(String operNo);


}
