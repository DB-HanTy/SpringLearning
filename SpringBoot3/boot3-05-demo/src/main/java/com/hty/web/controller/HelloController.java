package com.hty.web.controller;

import com.hty.web.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/person")
    public Person person(){
        Person person = new Person();
        person.setId(1001);
        person.setUsername("张三");
        person.setEmail("zhangsan@qq.com");
        person.setAge(18);
        return person;
    }
}
