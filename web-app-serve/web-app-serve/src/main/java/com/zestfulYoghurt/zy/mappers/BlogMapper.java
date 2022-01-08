package com.zestfulYoghurt.zy.mappers;

import com.zestfulYoghurt.zy.pojos.basePojo.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {

    public List<Blog> select(Blog blog);

    public void add(Blog blog);

    public void delete(Blog blog);

}
