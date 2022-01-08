package com.zestfulYoghurt.zy.controllers.register;

import com.zestfulYoghurt.zy.pojos.basePojo.MessageBean;
import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
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

    public ResultBean resultBean;

    @Resource(name = "registerServiceImp")
    private RegisterService registerServiceImp;

    @RequestMapping(value = "/register")
    public ResultBean register(@RequestBody User user) {

        //判断用户传递参数是否发生异常
        if(user != null){

            if(user.getUserName() != null && user.getPassword() != null){

                resultBean = registerServiceImp.register(user);

            }

        }else{

            log.error(MessageBean.PARAM_ERROR);

            resultBean = new ResultBean(-2,MessageBean.SYS_ERROR);

        }

        return resultBean;

    }

}
