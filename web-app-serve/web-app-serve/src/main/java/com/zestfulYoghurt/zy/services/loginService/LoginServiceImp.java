package com.zestfulYoghurt.zy.services.loginService;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.common.TextMessage;
import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.tool.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    private UserMapper userMapper;

    private User user;

    ResultBean<Map> resultBean;

    @Override
    public ResultBean loginCheckOut(String username, String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();

        try {

            subject.login(token);

            user = new User();
            user.setUserName(username);
            user.setPassword(password);

            List<User> users = userMapper.select(user);

            //登陆成功，创建jwt的token令牌
            // param1: 数据库用户加密的盐
            // param2: jwt创建token的有效时间
            JwtUtil jwtUtil = new JwtUtil(users.get(0).getSalt(),60*2*1000);

            //获取用户全部角色，封装成字符串,以"/"为分界
//            StringBuffer Roles = new StringBuffer();
//            Set<Role> roles = users.get(0).getRoles();
//            Iterator<Role> iterator = roles.iterator();
//            while (iterator.hasNext()){
//                Role role = iterator.next();
//                String roleName = role.getRoleName();
//                Roles.append(roleName).append("/");
//            }

            String JwtToken = jwtUtil.createJWT(users.get(0).getUserId(), users.get(0).getEmail(), "admin");

            HashMap<String, String> data = new HashMap<>();

            //返回用户id
            data.put("id",users.get(0).getUserId());

            //返回用户昵称
            data.put("NickName",users.get(0).getNickName());

            //返回用户角色 todo
            data.put("Role","admin");

            //返回用户状态
            data.put("Status",users.get(0).getStatus());

            //返回用户性别
            data.put("Sex",users.get(0).getSex());

            //返回用户创建时间
            data.put("Age",users.get(0).getCreateTime());

            //返回用户头像路径
            data.put("userImg",users.get(0).getAvatar());

            data.put("token",JwtToken);

            resultBean = new ResultBean<>(null,null,data);

        } catch (Exception e) {

            return new ResultBean(null, TextMessage.LOGIN_FAIL,null);
            //登录失败
            //resultBean = new ResultBean<>(e, FAIL_LOGIN, MessageBean.LOGIN_FAIL);

        }

        return resultBean;

    }

}
