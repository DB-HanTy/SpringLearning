package com.hty.order;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class interceptor implements RequestInterceptor {

    /**
     * 请求拦截器
     * @param requestTemplate 请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("请求拦截器启动");
        requestTemplate.header("X-token", UUID.randomUUID().toString());
    }
}
