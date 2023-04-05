package com.zestfulYoghurt.zy.services.registService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zestfulYoghurt.zy.pojos.Result;
import com.zestfulYoghurt.zy.pojos.User;
import com.zestfulYoghurt.zy.services.baseService.AddService;
import com.zestfulYoghurt.zy.services.baseService.SelectService;
import com.zestfulYoghurt.zy.tool.Tools;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegisterServiceImp implements RegisterService {

    @Resource
    private AddService addService;
    @Resource
    private SelectService selectService;
    Result<Object> result;

    @Override
    public Result<Object> register(User user)
    {
    	result = new Result<Object>();

        String salt = Tools.createSalt();
        String encryptionPassword = Tools.encryption.passwordEncryption
                (user.getPassword(), salt);
        user.setPassword(encryptionPassword);
        user.setSalt(salt);

        try{

        	User userFromDB = selectService.selectUser(user);

        	if(userFromDB == null){
        		addService.addUser(user);
        		return result;
        	}

        }catch (Exception ex){
        	log.debug("TODO");
        }

        result.RegistError();

        return result;
    }

}
