package com.hty.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {
    @Test
    public void testAdd(){
        //加载spring配置文件，创建对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        //获取配置创建的对象
        User user = (User) context.getBean("user");
        System.out.println("1:"+ user);

        //使用对象调用方法进行测试
        System.out.print("2:");
        user.add();



    }
    //反射创建对象
    @Test
    public void testUserObject() throws Exception {
        Class clazz = Class.forName("com.hty.spring6.User");
    //调用方法创建对象
        User user= (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
