package com.zestfulYoghurt.zy.services.registerService;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.basePojo.User;
import com.zestfulYoghurt.zy.services.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("registerServiceImp")
public class RegisterServiceImp implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Resource(name = "Validate")
    private Validate validate;


    //用户注册功能 todo 实现用户注册服务
    @Override
    public Map register(User user) {

        //todo 后期调用手机或者邮箱填写注册验证码
        HashMap<Object, Object> responseData = new HashMap<>();

        //向数据库插入用户信息之前进行用户名是否重复验证
        Integer result = validate.userRegisterValidate(user);

        switch (result){

            case 0:

                try{

                    userMapper.insert(user);

                }catch(Exception e){

                    responseData.put("message","注册失败，未知异常");

                }

                responseData.put("message","注册成功");

                break;

            case 1:

                responseData.put("message","注册失败，用户名重复");

                break;

        }

        return responseData;

    }

}
