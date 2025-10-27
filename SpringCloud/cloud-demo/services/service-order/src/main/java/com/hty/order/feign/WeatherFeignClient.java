package com.hty.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weather-client",url="天气地址")
public interface WeatherFeignClient {

    @PostMapping("/api/weather")
    void getWeather(@RequestHeader("Authorization") String auth,
                    @RequestParam("token") String token,
                    @RequestParam("cityId") String cityId);
}
