package com.hty.product.service;

import com.hty.product.bean.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Product getProductById(Long productId);
}
