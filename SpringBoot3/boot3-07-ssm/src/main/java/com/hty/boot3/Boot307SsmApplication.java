package com.hty.boot3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hty.boot3.mapper")
@SpringBootApplication
public class Boot307SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot307SsmApplication.class, args);
    }

}
