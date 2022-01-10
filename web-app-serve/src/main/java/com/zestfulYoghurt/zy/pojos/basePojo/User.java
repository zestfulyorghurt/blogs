package com.zestfulYoghurt.zy.pojos.basePojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * ClassName user
 * Description TODO 用户登陆者实体类
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/

@Data
public class User implements Serializable {

    //定义序列化id
    private static final Long serializableUID = 1L;

    //user的id(主键)
    private String userId;

    //用户名
    private String userName;

    //用户昵称
    private String nickName;

    //用户邮箱
    private String email;

    //用户手机号
    private String phoneNumber;

    //用户性别
    private String sex;

    //用户头像地址
    private String avatar;

    //定义用户密码
    private String password;

    //定义用户加密的盐
    private String salt;

    //账号状态
    private String status;

    //定义删除标志
    private String delFlag;

    //最后登录ip
    private String loginIp;

    //最后登录时间
    private String loginDate;

    //创建者
    private String createBy;

    //创建时间
    private String createTime;

    //更新者
    private String updateBy;

    //更新时间
    private String updateTime;

    //备注
    private String remark;

    //定义角色id
    private String rolesId;

    //定义用户拥有的角色
    private Set<Role> roles;

    //用户令牌
    private String token;

}
