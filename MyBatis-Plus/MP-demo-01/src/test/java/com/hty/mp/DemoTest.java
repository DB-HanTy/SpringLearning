package com.hty.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hty.mp.mapper.ProductMapper;
import com.hty.mp.mapper.UserMapper;
import com.hty.mp.pojo.Product;
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

    @Test
    public void test11(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        System.out.println(page);
    }

    @Test
    public void testPage(){
//���÷�ҳ����
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
//��ȡ��ҳ����
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("��ǰҳ��"+page.getCurrent());
        System.out.println("ÿҳ��ʾ��������"+page.getSize());
        System.out.println("�ܼ�¼����"+page.getTotal());
        System.out.println("��ҳ����"+page.getPages());
        System.out.println("�Ƿ�����һҳ��"+page.hasPrevious());
        System.out.println("�Ƿ�����һҳ��"+page.hasNext());
    }
    @Test
    public void testPage2(){
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPageVo(page,20);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());

    }
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void testConcurrentVersionUpdate() {
//小李取数据
        Product p1 = productMapper.selectById(1L);
//小王取数据
        Product p2 = productMapper.selectById(1L);
//小李修改 + 50
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改的结果：" + result1);
//小王修改 - 30
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改的结果：" + result2);
        if(result2 == 0){
//失败重试，重新获取version并更新
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productMapper.updateById(p2);
        }
        System.out.println("小王修改重试的结果：" + result2);
//老板看价格
        Product p3 = productMapper.selectById(1L);
        System.out.println("老板看价格：" + p3.getPrice());
    }

//    @Test
//    public void testSexEnum(){
//        User user = new User();
//        user.setName("Enum");
//        user.setAge(20);
////设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
//        user.setSex(SexEnum.MALE);
////INSERT INTO t_user ( username, age, sex ) VALUES ( ?, ?, ? )
////Parameters: Enum(String), 20(Integer), 1(Integer)
//        userMapper.insert(user);
//    }
}
