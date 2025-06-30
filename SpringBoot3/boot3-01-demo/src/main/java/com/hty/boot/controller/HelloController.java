package com.hty.boot.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody//标记返回纯文本或者json数据
@RestController
@ComponentScan("com.hty")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot 3!";
    }
}
