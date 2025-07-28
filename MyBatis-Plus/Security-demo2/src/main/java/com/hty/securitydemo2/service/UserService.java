package com.hty.securitydemo2.service;

import com.hty.securitydemo2.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 33038
* @description 针对表【user】的数据库操作Service
* @createDate 2025-07-26 22:34:40
*/
public interface UserService extends IService<User> {

    void saveUserDetails(User user);
}
