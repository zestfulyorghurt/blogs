package com.zestfulYoghurt.zy.controllers.login;

import com.zestfulYoghurt.zy.pojos.basePojo.MessageBean;
import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.services.loginService.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller("loginController")
public class LoginController {

    HttpSession session;

    //定义返回结果对象
    ResultBean resultBean;

    @Resource(name = "loginServiceImp")
    private LoginService loginServiceImp;

    @RequestMapping(value = "/loginCheckOut")
    @ResponseBody
    public Object loginCheckOut(@RequestBody User user) {

        //判断用户传递参数是否发生异常
        if(user!=null){

            if(user.getUserName() != null && user.getPassword() != null){

                resultBean = loginServiceImp.loginCheckOut(user.getUserName(),user.getPassword());

            }

        }else{

            log.error(MessageBean.PARAM_ERROR);

            resultBean = new ResultBean(-2,MessageBean.SYS_ERROR);

        }

        return resultBean;

    }

}
