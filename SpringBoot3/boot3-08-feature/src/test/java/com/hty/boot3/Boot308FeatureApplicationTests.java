package com.hty.boot3;

import com.hty.boot3.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot308FeatureApplicationTests {

    @Autowired
    HelloService helloService;

    @Test
    void contextLoads() {
        int sum = helloService.sum(1, 2);
        System.out.println(sum);
    }

}
