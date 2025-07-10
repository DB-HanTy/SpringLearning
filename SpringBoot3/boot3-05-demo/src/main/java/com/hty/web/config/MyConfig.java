package com.hty.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

//@Configuration
//public class MyConfig implements WebMvcConfigurer {
//
//
//
//
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        //保留以前规则
////        //自己写的新规则
////        registry.addResourceHandler("/static/**")//访问路径
////                .addResourceLocations("classpath:/a/","classpath:/b/")//静态资源路径
////                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));//缓存时间
////    }
//
//
//}

@Configuration //这是⼀个配置类,给容器中放⼀个 WebMvcConfigurer 组件，就能⾃定义底层
public class MyConfig /*implements WebMvcConfigurer*/ {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry)
            {
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/a/", "classpath:/ b/")
                                        .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
            }
        };
    }
}