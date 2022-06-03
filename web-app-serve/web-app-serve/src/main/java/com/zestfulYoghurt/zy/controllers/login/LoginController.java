package com.zestfulYoghurt.zy.controllers.login;

import com.zestfulYoghurt.zy.common.TextMessage;
import com.zestfulYoghurt.zy.common.ResultCode;
import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.services.loginService.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller("loginController")
public class LoginController {

    HttpSession session;

    //定义返回结果对象
    @Resource(name = "ResultBean")
    ResultBean resultBean;

    @Resource(name = "loginServiceImp")
    private LoginService loginServiceImp;

    @RequestMapping(value = "/loginCheckOut")
    @ResponseBody
    public Object loginCheckOut(@RequestBody User user) { //@RequestBody User user

        /*对前端发来的数据进行check*/
        //调用User类中的自身校验方法去校验前端传过来数据中{用户名}{密码}是否为空
        boolean isValued = user.isValued();
        //如果数据check出现问题
        if(!isValued){
            //设置返回值的错误代码为 {3}
            resultBean.setCode(ResultCode.DATA_FORMAT_ERROR);
            //设置错误信息为 {数据格式异常}
            resultBean.setMessage(TextMessage.DATA_FORMAT_ERROR);
        }

        /*调用Shiro对用户信息进行校验初始化用户{用户权限等等}*/



        return resultBean;

    }

}
