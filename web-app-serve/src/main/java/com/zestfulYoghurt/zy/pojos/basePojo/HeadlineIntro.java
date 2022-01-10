package com.zestfulYoghurt.zy.pojos.basePojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 头条简介实体类
 */

@Data
public class HeadlineIntro implements Serializable {

    private static final long serializableUID = 7L;

    //头条简介id
    private String id;

    //头条简介题目
    private String headlineTitle;

    //头条简介对应头条详细内容表的id
    private String headlineInDetail;


}
