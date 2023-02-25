package com.zestfulYoghurt.zy.services.baseService;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SelectService {

    @Resource
    UserMapper userMapper;


    public List<User> selectUserByName(User user)
    {
        List<User> userArrayList = null;
        try
        {
            userArrayList = userMapper.select(user);
            for(User userNumber : userArrayList)
            {
                userNumber.dataConvert();
            }

        }catch (Exception ex)
        {
            log.error("按名字查询用户失败");
        }

        return userArrayList;
    }


}
