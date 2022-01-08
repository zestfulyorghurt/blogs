package com.zestfulYoghurt.zy.shiro;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.basePojo.MessageBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.tool.Tools;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LoginRealm extends AuthorizingRealm {

    //定义密码加密次数
    public static final int count = 3;

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        log.info("授权");

        return null;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //定义简单认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;

        //获取令牌，从令牌中获取client传来的用户名和密码
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从令牌中获取用户名
        String username = userToken.getUsername();

        //从令牌中获取用户密码
        String password = null;
        Object passwordChar = userToken.getCredentials();
        if(passwordChar!=null){
            password = passwordChar.toString();
        }

        //将用户输入的用户名和密码封装成实体User类
        User user = new User();

        user.setUserName(username);

        //调用mappers以实体User类对象通过mybatis去查询数据库
        //通过用户名去查询
        List<User> userList = null;
        try{
            if(user.getUserName()!=null||user.getPassword()!=""&&user.getPassword()!=null||user.getPassword()!=""){
                userList = userMapper.select(user);
            }else{
                return simpleAuthenticationInfo;
            }
        }catch(Exception e) {
            log.info(e.toString());
        }

        //定义唯一用户名对应的用户
        User dbUser;

        if(userList!=null){
            //如果返回list的Size为0，则抛出异常，并打印日志
            if(userList.size() == 0){

                log.error(MessageBean.LOGIN_FAIL);

                throw new UnknownAccountException();

            }else{

                //如果根据用户名从数据库里查到的列表不等于0，就将list中的第一个值取出
                dbUser = userList.get(0);

                //将client发过来的用户密码进行加密处理:password--client传过来的密码,user.getSalt()--从数据库获取的用户加密所需要的盐,count--是
                //通过md5算法加密的次数
                String dbPassword = Tools.encryption.passwordEncryption(password, dbUser.getSalt(), count);

                //将加密过得用户密码和数据库中的密码进行对比，如果不同就抛出异常，并打印日志
                if(dbPassword.equals(dbUser.getPassword())){

                    log.error(MessageBean.LOGIN_FAIL_PASSWORD);

                    throw new UnsupportedTokenException();

                }else{

                    simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());

                }

            }
        }


        return simpleAuthenticationInfo;

    }

}
