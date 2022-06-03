package com.zestfulYoghurt.zy.pojos.basePojo;

import com.zestfulYoghurt.zy.common.ResultCode;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("ResultBean")
@Data
public class ResultBean<T> implements Serializable {

    //定义序列化的id
    private static final Long serializableUID = 3L;

    //定义默认返回信息
    private String message = "success";

    //定义返回代码
    private int code = ResultCode.SUCCESS;

    private T data;

    public ResultBean() {

        super();

    }

    public ResultBean(Integer Code, String Message, T data) {

        super();

        this.code = Code;

        this.message = Message;

        this.data = data;

    }

}
