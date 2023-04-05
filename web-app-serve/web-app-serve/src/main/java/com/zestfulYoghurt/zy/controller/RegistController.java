package com.zestfulYoghurt.zy.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zestfulYoghurt.zy.pojos.User;
import com.zestfulYoghurt.zy.services.registService.RegisterServiceImp;

@RestController
public class RegistController {

    @Resource
    RegisterServiceImp registerService;

    @PostMapping(value = "/regist")
    public Object register(@RequestBody User user) {

        return registerService.register(user);
    }

}
