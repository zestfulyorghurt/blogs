package com.zestfulYoghurt.zy.services.loginService;

import com.zestfulYoghurt.zy.pojos.basePojo.MessageBean;
import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import static com.zestfulYoghurt.zy.pojos.basePojo.ResultBean.FAIL_LOGIN;

/**
 * ClassName loginServiceImp
 * Description TODO 用户登录验证服务
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Service("loginServiceImp")
@Slf4j
public class LoginServiceImp implements LoginService {

    @Override
    public ResultBean loginCheckOut(String username, String password) {

        ResultBean<String> resultBean = null;

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();

        try {

            subject.login(token);

            resultBean = new ResultBean<>();

        } catch (Exception e) {

            //登录失败
            resultBean = new ResultBean<>(e, FAIL_LOGIN, MessageBean.LOGIN_FAIL);

        }

        return resultBean;

    }

}
