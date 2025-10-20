package com.hty.order.service.impl;
import java.math.BigDecimal;

import com.hty.order.bean.Order;
import com.hty.order.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();
        order.setId(1L);
        order.setTotalAmount(new BigDecimal("0"));
        order.setUserId(userId);
        order.setNickName("zhangsan");
        order.setAddress("hty");
        order.setProductList(null);

        return order;
    }
}
