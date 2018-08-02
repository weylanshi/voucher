package com.u8.sum.controller;

import com.u8.sum.consts.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Value("${user.userName}")
    private String userName;

    @Value("${user.password}")
    private String password;

    @RequestMapping("/login")
    public Result login( String username, String password) {
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return Result.ERROR("用户名或密码为空");
        }
        if(!username.equals(this.userName)||!password.trim().toLowerCase().equals(this.password)){
            return Result.ERROR("用户名或密码错误");
        }
        return Result.OK();
    }
}
