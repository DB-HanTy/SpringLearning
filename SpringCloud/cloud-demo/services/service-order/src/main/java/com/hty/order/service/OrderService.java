package com.hty.order.service;

import com.hty.order.bean.Order;

public interface OrderService {
    Order createOrder(Long productId,Long userId);
}
