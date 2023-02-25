package com.zestfulYoghurt.zy.services.baseService;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AddService {
    @Resource
    UserMapper userMapper;

    public void addOneUser(User user)
    {
        userMapper.insert(user);
    }

}
