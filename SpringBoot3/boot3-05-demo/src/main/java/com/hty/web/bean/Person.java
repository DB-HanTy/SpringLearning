package com.hty.web.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JacksonXmlRootElement
public class Person {
    private String username;
    private long id;
    private String email;
    private Integer age;
}
