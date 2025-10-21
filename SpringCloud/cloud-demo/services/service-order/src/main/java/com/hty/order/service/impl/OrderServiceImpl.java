package com.hty.order.service.impl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.hty.order.bean.Order;
import com.hty.order.service.OrderService;
import com.hty.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Product product = getProductFromRemoteWithLoadBalanceAnnotation(productId);
        Order order = new Order();
        order.setId(1L);
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("zhangsan");
        order.setAddress("hty");
        order.setProductList(Arrays.asList(product));

        return order;
    }

    //基于注解完成负载均衡发送请求
    private Product getProductFromRemoteWithLoadBalancer(Long productId){
        //1、获取到商品服务所在的所有机器IP+port
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        //远程URL
        String url = "http://"+ choose.getHost() + ":" + choose.getPort()+ "/product/" + productId;
        log.info("远程请求:{}",url);
        //2、给远程发送请求
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    //完成负载均衡发送请求
    private Product getProductFromRemoteWithLoadBalanceAnnotation(Long productId){

        String url = "http://service-product/product/" + productId;
        //2、给远程发送请求
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}
