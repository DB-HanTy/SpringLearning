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
//        System.out.println("��Ӱ��������"+result);
////1475754982694199298
//        System.out.println("id�Զ���ȡ��"+user.getId());
//    }

    @Test
    public void testDeleteById(){
//ͨ��idɾ���û���Ϣ
//DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1947924937402339329L);
        System.out.println("��Ӱ��������"+result);
    }

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        long count = userService.count();
        System.out.println("�ܼ�¼����"+count);
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
//�����ѯ�������п���Ϊnull���û�δ���룩
        String username = "a";
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//����ʹ���ַ�����ʾ�ֶΣ���ֹ����ʱ����
        queryWrapper
                .like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test10() {
//��װset�Ӿ�
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(User::getAge, 18)
                .set(User::getEmail, "user@atguigu.com")
                .like(User::getName, "a")
                .and(i -> i.lt(User::getAge, 24).or().isNull(User::getEmail)); //lambda���ʽ�ڵ��߼���������
        User user = new User();
        int result = userMapper.update(user, updateWrapper);
        System.out.println("��Ӱ���������" + result);
    }
}
