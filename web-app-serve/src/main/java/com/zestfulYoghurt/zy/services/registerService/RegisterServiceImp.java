package com.zestfulYoghurt.zy.services.registerService;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.basePojo.MessageBean;
import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.services.Validate;
import com.zestfulYoghurt.zy.tool.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("registerServiceImp")
public class RegisterServiceImp implements RegisterService {

    //用户重复
    public static final int REPETITION = 1;

    //用户不重复
    public static final int NOT_REPETITION = 0;

    @Autowired
    private UserMapper userMapper;

    @Resource(name = "Validate")
    private Validate validate;

    private ResultBean resultBean;


    //用户注册功能 todo 实现用户注册服务
    @Override
    public ResultBean register(User user) {

        //向数据库插入用户信息之前进行用户名是否重复验证
        int ifRepetition = validate.userNameRepetitionValidate(user);

        //将用户的密码进行加密,md5,两次加密
        String encryptionPassword = Tools.encryption.passwordEncryption(user.getPassword(), user.getUserName());

        //将加密后的密码封装到user对象中
        user.setPassword(encryptionPassword);

        if(ifRepetition == 0){

            //执行用户注册，将用户信息导入到数据库表中
            //向数据库插入数据如果出现异常，返回错误信息
            try{

                userMapper.insert(user);

            }catch(Exception e){

                resultBean = new ResultBean(-2,e, MessageBean.REGISTER_ERROR);

                return resultBean;

            }

        }else{

            resultBean = new ResultBean(-2,MessageBean.USERNAME_REPETITION);

        }


        return resultBean;

    }

}
