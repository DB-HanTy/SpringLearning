package com.hty.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hty
 * @Description: 启动springBoot项目的主入口程序
 * @date 2022/9/5 16:01
 */
@SpringBootApplication //这是一个SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);

    }
}
