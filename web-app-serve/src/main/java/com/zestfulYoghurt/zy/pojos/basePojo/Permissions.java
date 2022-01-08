package com.zestfulYoghurt.zy.pojos.basePojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 860120017
 * @title: Permissions
 * @projectName zy
 * @description: TODO 角色权限实体类
 * @date 2021/11/0315:07
 */

@Data
public class Permissions implements Serializable {

    private static final Long serializableUID = 5L;

    private String id;

    //具体权限名称
    private String permissionsName;

}
