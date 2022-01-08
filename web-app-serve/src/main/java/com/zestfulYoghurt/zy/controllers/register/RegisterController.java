package com.zestfulYoghurt.zy.controllers.register;

import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.services.registerService.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ClassName registerController
 * Description TODO 用户注册控制器
 * Author ZestfulYoghurt
 * Date 2021/06/30 2021.6.30
 * Version 1.0
 **/
@Controller
@Slf4j
public class RegisterController {

    @Resource(name = "registerServiceImp")
    private RegisterService registerServiceImp;

    @RequestMapping(value = "/register")
    public Map register(@RequestBody User user) {

        log.info("进入register方法");

        Map response = registerServiceImp.register(user);

        return response;

    }

}
