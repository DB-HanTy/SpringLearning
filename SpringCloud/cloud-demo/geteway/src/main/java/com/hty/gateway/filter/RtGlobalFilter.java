package com.hty.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class RtGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();


        String uri = request.getURI().toString();
        long start = System.currentTimeMillis();
        log.info("请求【{}】开始：时间：{}",uri,start);
        //============以上是前置逻辑===========

        Mono<Void> filter = chain.filter(exchange)
                .doFinally((result)->{
                    //==========以下是后置逻辑===========
                    long end = System.currentTimeMillis();
                    log.info("请求【{}】结束：时间：{}，耗时：{}",uri,end,end-start);
                });
        return filter;
    }

    public int getOrder() {
        return 0;
    }


}
