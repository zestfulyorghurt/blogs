package com.zestfulYoghurt.zy.controllers.login;

import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.services.loginService.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Slf4j
@Controller("loginController")
public class LoginController {

    ResultBean resultBean;

    private String username = null;

    private String password = null;

    @Resource(name = "loginServiceImp")
    private LoginService loginServiceImp;

    //获取前端传过来的username和password
    //根据username和password的值判断是否进行登录验证，不为空直接调用service进行登录验证，为空直接返回结果
    @RequestMapping(value = "/loginCheckOut")
    @ResponseBody
    public Object loginCheckOut( @RequestBody User user) {

        if(user!=null){

            if(user.getUserName() != null && user.getUserName() != ""){

                username = user.getUserName();

            }

            if(user.getPassword() != null && user.getPassword() != ""){

                password = user.getPassword();

            }

            if(username != null && password != null){

                resultBean = loginServiceImp.loginCheckOut(username,password);

            }else{

                resultBean = new ResultBean(-2,"用户名或者密码不能为空","登录失败");

            }

        }

        return resultBean;

    }

}
