package com.zestfulYoghurt.zy.services.loginService;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.zestfulYoghurt.zy.pojos.Result;
import com.zestfulYoghurt.zy.pojos.User;
import com.zestfulYoghurt.zy.services.baseService.SelectService;
import com.zestfulYoghurt.zy.tool.JsonConvert;
import com.zestfulYoghurt.zy.tool.JwtUtil;

/**
 * ClassName loginServiceImp
 * Description TODO 用户登录验证服务
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Service
public class LoginServiceImp implements LoginService {

    @Resource
    private SelectService selectService;

    Result<Object> result;

    @Override
    public Result<Object> login(User user) {

    	result = new Result<Object>();
        UsernamePasswordToken token =
        		new UsernamePasswordToken
        		(user.getUserName(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();

        try{
            subject.login(token);
        }catch (Exception e){
        	result.AuthenticationError();
        	return result;
        }

        User userFromDB = selectService.selectUser(user);
        User jwtUser = userFromDB;
        jwtUser.setPassword("");

        HashMap<String,String> hashMap = new HashMap<String,String>();
        String jwtToken = JwtUtil.createJWT(jwtUser);
        hashMap.put("token", jwtToken);
        hashMap.put("user", JsonConvert.ObjectToJson(jwtUser));
        result.setData(hashMap);

        return result;

    }

}
