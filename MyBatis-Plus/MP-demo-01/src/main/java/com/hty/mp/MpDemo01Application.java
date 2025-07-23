package com.hty.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.hty.mp.mapper")
public class MpDemo01Application {

	public static void main(String[] args) {

		SpringApplication.run(MpDemo01Application.class, args);
	}

}
