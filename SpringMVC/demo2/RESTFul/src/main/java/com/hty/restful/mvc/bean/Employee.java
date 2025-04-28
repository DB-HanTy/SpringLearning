package com.hty.restful.mvc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
}
