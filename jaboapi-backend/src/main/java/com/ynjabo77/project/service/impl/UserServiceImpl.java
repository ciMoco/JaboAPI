package com.ynjabo77.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.User;
import com.ynjabo77.project.service.UserService;
import com.ynjabo77.project.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ynjabo77
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-06-30 10:40:28
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




