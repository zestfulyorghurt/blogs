package com.zestfulYoghurt.zy.services.baseService.blogService;

import com.zestfulYoghurt.zy.mappers.BlogMapper;
import com.zestfulYoghurt.zy.pojos.basePojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:ZestfulYoghurt
 * @Date: 2021/8/14 19:14
 * @Description: 1.查询博客
 */
@Service("blogServiceImp")
public class BlogServiceImp implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> getBlog(Blog blog) {

        List<Blog> blogs = blogMapper.select(blog);

        return blogs;

    }

    @Override
    public void addBlog(Blog blog) {

        blogMapper.add(blog);

    }

    @Override
    public void updateBlog(Blog blog) {

        //todo 需要修改，这个地方需要添加事务来保证其原子性
        blogMapper.delete(blog);

        blogMapper.add(blog);

    }

    //逻辑删除，对数据的删除时间进行设置
    @Override
    public void deleteBlog(Blog blog) {

        //todo 需要修改，这个地方需要添加事务来保证其原子性
        blogMapper.delete(blog);

        blogMapper.add(blog);

    }

    //物理删除
    @Override
    public void delete(Blog blog) {

        blogMapper.delete(blog);

    }

}
