package com.zestfulYoghurt.zy.pojos.basePojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {

    //定义序列化的id
    private static final Long serializableUID = 3L;

    //定义登录失败的错误代码
    public static final int FAIL_LOGIN = -2;

    //定义没有登录的代码
    public static final int NO_LOGIN = -1;

    //定义登录成功的代码
    public static final int SUCCESS = 0;

    //
    public static final int FAIL = 1;

    //定义没有权限的错误代码
    public static final int NO_PERMISSION = 2;

    //定义默认返回信息
    private String message = "success";

    //定义返回代码
    private int code = SUCCESS;

    private T data;

    public ResultBean() {

        super();

    }

    public ResultBean(T data) {

        super();

        this.data = data;

    }

    public ResultBean(Throwable e, Integer Code, T data) {

        super();

        this.message = e.toString();

        this.code = Code;

        this.data = data;

    }

    public ResultBean(Integer Code, T data, String Message) {

        super();

        this.code = Code;

        this.data = data;

        this.message = Message;

    }

}
