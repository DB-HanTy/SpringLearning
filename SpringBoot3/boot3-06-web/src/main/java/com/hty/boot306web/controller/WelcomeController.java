package com.hty.boot306web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    /**
     * 跳转到欢迎页面
     * @param name
     * @return
     */
    @GetMapping("/welcome")
    public String welcome(@RequestParam("name") String name,
                          Model model){
        //模板的逻辑视图名
        //物理视图 = 前缀 + 逻辑视图名 + 后缀
        //真实地址 = /WEB-INF/templates/welcome.html

        //把需要给页面共享的数据放到model

        model.addAttribute("name",name);
        return "welcome";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
