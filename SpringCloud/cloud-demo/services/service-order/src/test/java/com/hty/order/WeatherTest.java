package com.hty.order;

import com.hty.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherTest {
    @Autowired
    WeatherFeignClient weatherFeignClient;

    @Test
    public void testWeather() {
        weatherFeignClient.getWeather("Bearer 123", "123", "101010100");
        System.out.println("调用天气服务成功");
    }
}
