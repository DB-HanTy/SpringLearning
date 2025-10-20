package com.hty.product.bean;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
