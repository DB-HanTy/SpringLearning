package com.hty.boot3.bean;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Data
@Component
public class Dog {
    private String name;
    private Integer age;
    private Integer weight;
}
