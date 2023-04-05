package com.zestfulYoghurt.zy.services.baseService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SelectService {

    @Resource
    UserMapper userMapper;

    public User selectUser(User user)
    {
        User userResult = null;
        try
        {
        	userResult = userMapper.select(user);
            //将java中的对象类型转成json实现对象存储到数据库，取出时进行转换
        	userResult.dataConvert();
        }catch (Exception ex)
        {
            log.error("按名字查询用户失败");
        }
        return userResult;
    }

}
