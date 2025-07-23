package com.hty.mp;

import com.hty.mp.mapper.UserMapper;
import com.hty.mp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User(null, "zhangsan", 23, "123@163.com");
//INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        int result = userMapper.insert(user);
        System.out.println("受影响行数："+result);
//1475754982694199298
        System.out.println("id自动获取："+user.getId());
    }

    @Test
    public void testDeleteById(){
//通过id删除用户信息
//DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1947924937402339329L);
        System.out.println("受影响行数："+result);
    }
    
}
