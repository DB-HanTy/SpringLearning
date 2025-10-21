package com.hty.order.controller;

import com.hty.order.bean.Order;
import com.hty.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope//刷新配置
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Value("${order.timeout}")
    String orderTimeout;

    @Value("${order.auto-confirm}")
    String orderAutoConfirm;

    @GetMapping("/config")
    public String config(){
        return "order.timeout="+orderTimeout+": order.auto-confirm="+orderAutoConfirm;
    }

    //创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId){
        Order order = orderService.createOrder(productId, userId);
        return order;
    }
}
