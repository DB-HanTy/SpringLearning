package com.hty.boot3.bean;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Data
@Component
public class Cat {
    private String name;
    private Integer age;
    private Integer weight;
}
