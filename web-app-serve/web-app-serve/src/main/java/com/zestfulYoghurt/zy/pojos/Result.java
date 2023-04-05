package com.zestfulYoghurt.zy.pojos;

import org.springframework.stereotype.Component;

import com.zestfulYoghurt.zy.common.Message;
import com.zestfulYoghurt.zy.common.ResultCode;

import lombok.Data;

@Component
@Data
public class Result<T>{
    private String message = "";
    private int code = ResultCode.SuccessCode;
    private T data;

    public Result() {
        super();
    }

    public Result(Integer Code, String Message, T data) {
        super();
        this.code = Code;
        this.message = Message;
        this.data = data;
    }

    //认证失败
    public void AuthenticationError() {
    	this.code = ResultCode.AuthenticationErrorCode;
    	this.message = Message.AuthenticationError;
    }

    //实体类check错误
    public void ModelCheckError() {
    	this.code = ResultCode.ModelCheckErrorCode;
    	this.message = Message.ModelCheckError;
    }

    //没有权限
    public void NoPermissionError() {
    	this.code = ResultCode.NoPermissionErrorCode;
    	this.message = Message.NoPermissionError;
    }

    //注册失败
    public void RegistError() {
    	this.code = ResultCode.RegistErrorCode;
    	this.message = Message.RegistError;
    }

}
