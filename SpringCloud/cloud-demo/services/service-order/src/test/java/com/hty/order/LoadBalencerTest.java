package com.hty.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBalencerTest {

    @Autowired
    LoadBalancerClient loadBalencerClient;
    @Test
    void test(){

        ServiceInstance choose = loadBalencerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalencerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalencerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalencerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
        choose = loadBalencerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
    }
}
