package com.hty.boot.config;

import com.hty.boot.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    /**
     * 1、组件默认是单实例的
     * @return
     */
    @Bean("cat01")
    @Scope("prototype")//组件变为多实例
    public Cat cat01(){
        var cat = new Cat();
        cat.setName("tom");
        cat.setAge(1);
        cat.setWeight(1.2);
        return cat;
    }
}
