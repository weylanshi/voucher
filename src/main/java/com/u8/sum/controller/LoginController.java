package com.u8.sum.controller;

import com.u8.sum.consts.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Value("user.userName")
    private String userName;

    @Value("user.password")
    private String password;

    @RequestMapping("/api/login")
    public Result login(String userName,String password) {
        if(StringUtils.isBlank(userName)||StringUtils.isBlank(password)){
            return Result.ERROR("用户名或密码为空");
        }
        if(!password.trim().toLowerCase().equals(password)){
            return Result.ERROR("用户名或密码错误");
        }
        return Result.OK();
    }
}
