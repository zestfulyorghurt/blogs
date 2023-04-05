package com.zestfulYoghurt.zy.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zestfulYoghurt.zy.pojos.User;
import com.zestfulYoghurt.zy.services.loginService.LoginServiceImp;

@RestController
public class LoginController {

    @Resource
    LoginServiceImp loginService;

    @PostMapping(value = "/login")
    public Object login(@RequestBody User user) {

        return loginService.login(user);
    }

}
