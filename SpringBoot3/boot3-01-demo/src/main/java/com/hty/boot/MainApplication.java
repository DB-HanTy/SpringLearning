package com.hty.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hty
 * @Description: 启动springBoot项目的主入口程序
 * @date 2022/9/5 16:01
 */
@SpringBootApplication(scanBasePackages = "com.hty") //这是一个SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
       //java10: var局部变量类型自动推断
        var ioc = SpringApplication.run(MainApplication.class, args);
////1、获取容器中所有组件的名字
//        String[] names = ioc.getBeanDefinitionNames();
//        //2、挨个遍历：
//        // dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
//        // SpringBoot把以前配置的核⼼组件现在都给我们⾃动配置好了。
//        for (String name : names) {
//            System.out.println(name);
//        }
        System.out.println(ioc.getBean("cat01"));
    }
}
