package com.hty.web.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Person {
    private String username;
    private long id;
    private String email;
    private Integer age;
}
