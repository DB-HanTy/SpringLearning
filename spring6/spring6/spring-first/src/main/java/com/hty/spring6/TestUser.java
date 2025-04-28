package com.hty.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {
    @Test
    public void testAdd(){
        //����spring�����ļ�����������
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        //��ȡ���ô����Ķ���
        User user = (User) context.getBean("user");
        System.out.println("1:"+ user);

        //ʹ�ö�����÷������в���
        System.out.print("2:");
        user.add();



    }
    //���䴴������
    @Test
    public void testUserObject() throws Exception {
        Class clazz = Class.forName("com.hty.spring6.User");
    //���÷�����������
        User user= (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
