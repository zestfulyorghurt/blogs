package com.zestfulYoghurt.zy.services.loginService;

import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;

/**
 * InterfaceName loginService
 * Description TODO 用户登录接口
 * Author ZestfulYoghurt
 * Date 2021/06/02 2022.6.2
 * Version 1.0
 **/
public interface LoginService {

    ResultBean loginCheckOut(String username, String password);

}
