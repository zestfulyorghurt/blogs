package com.zestfulYoghurt.zy.services.registerService;

import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import org.springframework.stereotype.Component;

import java.util.Map;

public interface RegisterService {

    //用户注册功能 todo 实现用户注册服务
    ResultBean register(User user);

}
