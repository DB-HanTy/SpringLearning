package com.hty.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hty.mp.mapper.UserMapper;
import com.hty.mp.pojo.User;
import com.hty.mp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DemoTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        userMapper.selectList(null).forEach(System.out::println);
    }

//    @Test
//    public void testInsert(){
//        User user = new User(null, "zhangsan", 23, "123@163.com");
////INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
//        int result = userMapper.insert(user);
//        System.out.println("受影响行数："+result);
////1475754982694199298
//        System.out.println("id自动获取："+user.getId());
//    }

    @Test
    public void testDeleteById(){
//通过id删除用户信息
//DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1947924937402339329L);
        System.out.println("受影响行数："+result);
    }

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        long count = userService.count();
        System.out.println("总记录数："+count);
    }

    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .between("age",20,30)
                .isNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .between("age",20,30)
                .isNull("email");
                updateWrapper.set("age",18);
        int result = userMapper.update(null, updateWrapper);
        System.out.println(result);
    }
    @Test
    public void test09() {
//定义查询条件，有可能为null（用户未输入）
        String username = "a";
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//避免使用字符串表示字段，防止运行时错误
        queryWrapper
                .like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test10() {
//组装set子句
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(User::getAge, 18)
                .set(User::getEmail, "user@atguigu.com")
                .like(User::getName, "a")
                .and(i -> i.lt(User::getAge, 24).or().isNull(User::getEmail)); //lambda表达式内的逻辑优先运算
        User user = new User();
        int result = userMapper.update(user, updateWrapper);
        System.out.println("受影响的行数：" + result);
    }
}
