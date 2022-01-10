package com.zestfulYoghurt.zy.services;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName Validate
 * Description TODO
 * Author ZestfulYoghurt
 * Date 2021/07/23 2021.7.23
 * Version 1.0
 **/
@Service("Validate")
public class Validate {

    @Autowired
    private UserMapper userMapper;

    //效验数据库是否有重复的用户名
    public Integer userNameRepetitionValidate(User user) {

        List<User> users = userMapper.select(user.getUserName(),user.getPassword());

        if (users == null) {

            return 0;

        }

        return 1;

    }

}
