package com.zestfulYoghurt.zy.services.loginService;

import com.zestfulYoghurt.zy.pojos.Result;
import com.zestfulYoghurt.zy.pojos.User;

/**
 * InterfaceName loginService
 * Description TODO 用户登录接口
 * Author ZestfulYoghurt
 * Date 2021/06/02 2022.6.2
 * Version 1.0
 **/
public interface LoginService {

    Result<Object> login(User user);

}
