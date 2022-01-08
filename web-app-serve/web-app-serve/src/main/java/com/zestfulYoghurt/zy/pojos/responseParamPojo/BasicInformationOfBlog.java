package com.zestfulYoghurt.zy.pojos.responseParamPojo;

import lombok.Data;

/**
 * ClassName BasicInformationOfBlog
 * Description TODO 这是微博基础消息的数据封装类,属于返回值实体类
 * Author ZestfulYoghurt
 * Date 2021/08/30 8.30
 * Version 1.0
 **/

@Data
public class BasicInformationOfBlog {

    public String BlogTitle;

    public String BlogContext;

    public String IsLike;

    public String IsNotLike;

    public String BlogAuthor;

    public String BlogCreatData;

    public Integer BlogCommentCount;

    public Integer BlogBrowseCount;

    public Integer BlogLikeCount;

    public Integer BlogNotLikeCount;

    public String imgUrl;

}

