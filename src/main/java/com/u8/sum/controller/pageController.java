package com.u8.sum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class pageController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/api/test")
    @ResponseBody
    public String test(){
        return "hello";
    }

}
