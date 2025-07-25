package com.hty.mybatisplus.service.impl;

import com.hty.mybatisplus.entity.User;
import com.hty.mybatisplus.mapper.UserMapper;
import com.hty.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hty
 * @since 2025-07-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
