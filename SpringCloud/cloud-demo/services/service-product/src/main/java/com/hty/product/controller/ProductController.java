package com.hty.product.controller;

import com.hty.product.bean.Product;
import com.hty.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/product")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    //查询商品
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long ProductId){
        Product  product = productService.getProductById(ProductId);
        return product;
    }
}
