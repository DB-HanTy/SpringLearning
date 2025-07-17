package com.hty.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WelcomeController {

    //利用模板引擎渲染页面
    @GetMapping("/wel")
    public String welcome() {
        //模板的逻辑视图名
        //物理视图= 前缀+逻辑视图名+后缀
        //真实地址= classpath:/templates/welcome.html
        return "welcome";
    }
}
