package com.unicom.back.controller;

import com.alibaba.fastjson.JSONObject;
import com.unicom.back.service.SystemService;
import com.unicom.back.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="user")
public class UserController {

    @Autowired
    private SystemService systemService;

    @PostMapping(value = "check")
    public JSONObject checkUser(@RequestParam String operNo,
                                @RequestParam String password) {
        boolean flag=systemService.getUser(operNo).getPassword().equals(password);
        return Util.getJsonObject("{'flag':"+flag+"}");
    }



}
