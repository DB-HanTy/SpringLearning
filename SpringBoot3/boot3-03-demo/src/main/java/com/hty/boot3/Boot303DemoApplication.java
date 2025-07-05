package com.hty.boot3;

import com.hty.boot3.pojo.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Boot303DemoApplication {

    public static void main(String[] args) {

        var ioc = SpringApplication.run(Boot303DemoApplication.class, args);

        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }
}
