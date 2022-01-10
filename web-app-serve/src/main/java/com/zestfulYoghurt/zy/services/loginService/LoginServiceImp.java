package com.zestfulYoghurt.zy.services.loginService;

import com.zestfulYoghurt.zy.mappers.PermissionsMapper;
import com.zestfulYoghurt.zy.mappers.RolesMapper;
import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.basePojo.*;
import com.zestfulYoghurt.zy.tool.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RolesMapper rolesMapper;

    @Autowired
    private PermissionsMapper permissionsMapper;

    private User user;

    ResultBean<User> resultBean;

    @Override
    public ResultBean loginCheckOut(String username, String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();

        try {

            //验证用户名和密码是否正确
            subject.login(token);

            List<User> users = userMapper.select(username,password);

            //数据库中查询出来的用户
            User db_user = users.get(0);

            //获取用户全部角色以及对应权限
            //从数据库获取用户对应所拥有的角色id
            String roles_id_string = db_user.getRolesId();

            //将用户角色id进行分割
            String[] roles_id = roles_id_string.split("/");

            //根据角色id去查询对应角色
            Set<Role> roles = rolesMapper.select(roles_id);

            //将每个用户的权限装到对应的角色中
            Iterator<Role> iterator = roles.iterator();
            while (iterator.hasNext()){
                Role role = iterator.next();
                String permissions_id_string = role.getPermissionsId();
                String[] permissions_id = permissions_id_string.split("");
                Set<Permissions> permissions = permissionsMapper.select(permissions_id);
                role.setPermissions(permissions);
            }

            db_user.setRoles(roles);

            //登陆成功，创建jwt的token令牌
            // param1: 数据库用户加密的盐
            // param2: jwt创建token的有效时间，设置为半小时
            JwtUtil jwtUtil = new JwtUtil(db_user.getSalt(),60*30*1000);
            String JwtToken = jwtUtil.createJWT(db_user.getUserId(), db_user.getEmail(), db_user.getRoles().toString());

            //将用户名，用户id，用户状态，用户性别，用户创建时间，用户头像路径,生成的token撞到user对象中
            //将用户角色进行封装
            user = new User();
            user.setRoles(roles);
            user.setUserName(db_user.getUserName());
            user.setUserId(db_user.getUserId());
            user.setStatus(db_user.getStatus());
            user.setSex(db_user.getSex());
            user.setCreateTime(db_user.getCreateTime());
            user.setAvatar(db_user.getAvatar());
            user.setToken(JwtToken);

            resultBean = new ResultBean<>(user);

        } catch (Exception e) {

            return new ResultBean(e, FAIL_LOGIN, MessageBean.LOGIN_FAIL);

        }

        return resultBean;

    }

}
