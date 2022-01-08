package com.zestfulYoghurt.zy.pojos.basePojo;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName blog
 * Description TODO 博客表实体映射类
 * Author ZestfulYoghurt
 * Date 2021/08/30 8.30
 * Version 1.0
 **/

/**
 * @Author ZestfulYoghurt
 * @Description //TODO 博客实体类
 * @Date 17:50 2021/08/30
 * @Param 博客id 博客题目 博客内容 博客作者 博客创作时间 博客评论数 博客浏览量 博客点赞数量 博客点踩数量 博客的图片路径
 **/

//该注解可以提供getter，setter方法
@Data

public class Blog implements Serializable {

    private static final long serializableUID = 2L;

    private Integer blogId;

    private String blogTitle;

    private String blogContext;

    private String blogAuthor;

    private String blogCreatData;

    private Integer blogCommentCount;

    private Integer blogBrowseCount;

    private Integer blogLikeCount;

    private Integer blogNotLikeCount;

    private String imgUrl;

}

