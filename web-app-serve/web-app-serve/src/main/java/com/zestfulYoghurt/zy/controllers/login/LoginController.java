package com.zestfulYoghurt.zy.controllers.login;

import com.zestfulYoghurt.zy.common.TextMessage;
import com.zestfulYoghurt.zy.common.ResultCode;
import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.Role;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.services.baseService.AddService;
import com.zestfulYoghurt.zy.services.loginService.LoginService;
import com.zestfulYoghurt.zy.shiro.LoginRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashSet;

@Slf4j
@Controller("loginController")
public class LoginController {

    //定义返回结果对象
    //@Resource(name = "ResultBean")
    ResultBean resultBean = new ResultBean();

    @Resource(name = "loginServiceImp")
    private LoginService loginServiceImp;

    @Resource
    AddService addService;

    @Resource(name = "myShiroRealm")
    LoginRealm shiroRealm;

    @RequestMapping(value = "/loginCheckOut")
    @ResponseBody
    public Object loginCheckOut(@RequestBody User user) {
        /*对前端发来的数据进行check*/
        //调用User类中的自身校验方法去校验前端传过来数据中{用户名}{密码}是否为空
        boolean isValued = user.isValued();
        //如果数据check出现问题
        if(!isValued)
        {
            //设置返回值的错误代码为 {3}
            resultBean.setCode(ResultCode.DATA_FORMAT_ERROR);
            //设置错误信息为 {数据格式异常}
            resultBean.setMessage(TextMessage.DATA_FORMAT_ERROR);
        }

        //账号密码令牌
        String userName = user.getUserName();
        String userPassword = user.getPassword();
        AuthenticationToken token =
                new UsernamePasswordToken(userName, userPassword);

        //获得当前用户到登录对象，现在状态为未认证
        Subject subject = SecurityUtils.getSubject();
        try
        {
            //将令牌传到shiro提供的login方法验证，需要自定义realm
            subject.login(token);
        }
        catch (IncorrectCredentialsException ice)
        {
            resultBean.setMessage("用户名或密码不正确！");
        }
        catch (UnknownAccountException uae)
        {
            resultBean.setMessage("未知账户！");
        }
        catch (LockedAccountException lae)
        {
            resultBean.setMessage("账户被锁定！");
        }
        catch (DisabledAccountException dae)
        {
            resultBean.setMessage("账户被禁用！");
        }
        catch (ExcessiveAttemptsException eae)
        {
            resultBean.setMessage("用户名或密码错误次数太多！");
        }
        catch (AuthenticationException ae)
        {
            resultBean.setMessage("验证未通过！");
        }
        catch (Exception e)
        {
            resultBean.setMessage("验证未通过！");
        }

        return resultBean;
    }


    @RequiresPermissions(value = "123456")
    @RequestMapping(value = "/registe")
    @ResponseBody
    public Object regist(@RequestBody User user) throws IOException {
        User user1 = new User();
        user1.setUserName("zhang2");
        user1.setPassword("zhang2");
        HashSet<Role> roles = new HashSet<>();
        Role tt = new Role();
        tt.setRoleName("test");
        roles.add(tt);
        user1.setRoles(roles);
        user1.dataConvert();
        addService.addOneUser(user1);
        //shiroRealm.clearCachedAuthorizationInfo( SecurityUtils.getSubject().getPrincipals() );
        SecurityUtils.getSubject().logout();
        return resultBean;
    }

}
