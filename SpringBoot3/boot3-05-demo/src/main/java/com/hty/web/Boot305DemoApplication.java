package com.hty.web;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.hty.web.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot305DemoApplication {

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setId(1L);
        person.setUsername("张三");
        person.setEmail("aaa@qq.com");
        person.setAge(18);
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.
                WRITE_DOC_START_MARKER);
        ObjectMapper mapper = new ObjectMapper(factory);
        String s = mapper.writeValueAsString(person);
        System.out.println(s);
    }

}
