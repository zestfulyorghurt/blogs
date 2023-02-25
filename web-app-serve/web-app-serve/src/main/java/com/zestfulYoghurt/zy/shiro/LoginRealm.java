package com.zestfulYoghurt.zy.shiro;
import com.zestfulYoghurt.zy.pojos.basePojo.Permissions;
import com.zestfulYoghurt.zy.pojos.basePojo.Role;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.services.baseService.SelectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private SelectService selectService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo
            (PrincipalCollection principals)
    {
        SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
        //获取用户信息，从shiro验证方法中自己设置的值（simpleAuthenticationInfo）
        User userInfo = (User) principals.getPrimaryPrincipal();
        //创建给shiro的权限list
        ArrayList<String> permissionInfoIdList = new ArrayList<String>();
        Set<Role> roleInfoList = userInfo.getRoles();
        //每一个角色中包含若干个权限，通过双层for循环把角色和权限添加到shiro中
        //roleInfoList.forEach(role ->
        //{
        if(roleInfoList != null)
        {
            for(Role role:roleInfoList)
            {
                authorization.addRole(role.getId());
                Set<Permissions> permissionInfoSet = role.getPermissions();
                if(permissionInfoSet != null)
                {
                    for (Permissions permission : permissionInfoSet) {
                        permissionInfoIdList.add(permission.getId());
                    }
                    authorization.addStringPermissions(permissionInfoIdList);
                }
            }
        }
        //});

        return authorization;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo
            (AuthenticationToken token)
            throws AuthenticationException
    {
        User user = new User();
        List<User> userList;
        //定义准备传给shiro框架的简单用户认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo;
        //从controller中创建的token中取出用户名，放到查询参数中
        user.setUserName((String)token.getPrincipal());

        userList = selectService.selectUserByName(user);

        if(userList!=null)
        {
            if(userList.size() != 0)
            {
                simpleAuthenticationInfo =
                new SimpleAuthenticationInfo
                (userList.get(0), //将整个用户信息传给shiro，在授权方法中可以取出使用
                 userList.get(0).getPassword(), //将数据库中用户的密码传个shiro，让shiro进行密码比对
                 ByteSource.Util.bytes(""),//将数据库中用户加密的盐传给shiro辅助密码比对 TODO 还没有改
                 getName());//将loginRealm的类名传给shiro

                return simpleAuthenticationInfo;
            }
            //抛出未知用户异常
            throw new UnknownAccountException();
        }
        //抛出数据库查询异常
        throw new UnknownAccountException();//TODO 要修改异常类型
    }

}

    /*
        DisabledAccountException（禁用的帐号）、
        LockedAccountException（锁定的帐号）、
        UnknownAccountException（错误的帐号）、
        ExcessiveAttemptsException（登录失败次数过多）、
        IncorrectCredentialsException （错误的凭证）、
        ExpiredCredentialsException（过期的凭证）等
        //char[] passwordChar = (char[]) userToken.getCredentials(); //获取用户密码
    */
