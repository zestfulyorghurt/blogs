package com.zestfulYoghurt.zy.controllers.getResources;

import com.zestfulYoghurt.zy.pojos.basePojo.Blog;
import com.zestfulYoghurt.zy.pojos.basePojo.ResultBean;
import com.zestfulYoghurt.zy.services.baseService.blogService.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:ZestfulYoghurt
 * @Date: 2021/8/14 19:31
 * @Description:获取博客的简单信息 todo 以后可能会添加数据，要进行修改
 */
//@Slf4j是实现日志的快速打印，无需去自己创建日志对象
@Slf4j
@Controller("getDate")
@RequestMapping("/getResources")
public class GetDate {

    @Resource(name = "blogServiceImp")
    private BlogService blogServiceImp;

    @RequestMapping(value = "/getBlog")
    @ResponseBody
    public Object getBasicInformationOfBlog() {

        Blog blog = new Blog();

        blog.setBlogId(-1);

        List<Blog> blogs = blogServiceImp.getBlog(blog);

        ResultBean resultBean = new ResultBean(null,null,blogs);

        return resultBean;

    }

    @RequestMapping(value = "/getUsers")
    public Object getUserInfo(){

        ResultBean<Object> resultBean = new ResultBean<>();

        return resultBean;

    }

}
