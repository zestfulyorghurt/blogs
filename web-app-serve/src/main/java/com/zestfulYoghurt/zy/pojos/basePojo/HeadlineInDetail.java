package com.zestfulYoghurt.zy.pojos.basePojo;

import lombok.Data;

import java.io.Serializable;


@Data
public class HeadlineInDetail implements Serializable {

    public static final Long serializableUID = 8L;

    //头条详细id
    private String id;

    //头条详细作者
    private String writer;

    //头条创建时间
    private String createTime;

    //头条浏览数量
    private String browseCount;

    //头条收藏数量
    private String collectCount;

    //头条文章内容
    private String detailContent;

}
