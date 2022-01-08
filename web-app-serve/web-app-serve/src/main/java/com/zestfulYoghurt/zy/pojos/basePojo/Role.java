package com.zestfulYoghurt.zy.pojos.basePojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * ClassName user
 * Description 用户角色实体类
 * Author ZestfulYogurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/

@Data
public class Role implements Serializable {

    //定义序列化的id
    private static final Long serializableUID = 4L;

    //定义角色的id(主键)
    private String id;

    //定义角色name名称
    private String roleName;

    //定义每个角色有的权限
    private Set<Permissions> permissions;

}
