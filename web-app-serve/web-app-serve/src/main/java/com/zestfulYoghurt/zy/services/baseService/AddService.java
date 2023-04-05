package com.zestfulYoghurt.zy.services.baseService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.User;

@Service
public class AddService {
    @Resource
    UserMapper userMapper;

    public void addUser(User user)
    {
        userMapper.insert(user);
    }

}
