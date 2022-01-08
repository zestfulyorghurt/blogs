package com.zestfulYoghurt.zy.services.baseService.blogService;

import com.zestfulYoghurt.zy.pojos.basePojo.Blog;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:ZestfulYoghurt
 * @Date: 2021/8/14 19:04
 * @Description: 博客相关服务：
 * 1.查询博客
 * 2.添加一篇博客
 * 3.修改博客的信息
 * 4.删除一条博客，采用逻辑删除的方法，会员有30天找回功能，一般用户直接定期清理
 * 5.物理删除
 */
@Component
public interface BlogService {

    List<Blog> getBlog(Blog blog);

    void addBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(Blog blog);

    void delete(Blog blog);

}
