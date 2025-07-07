package com.hty.boot3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        log.info("hello spring boot 3.0");
        return "Hello Spring Boot 3.0";
    }
}
