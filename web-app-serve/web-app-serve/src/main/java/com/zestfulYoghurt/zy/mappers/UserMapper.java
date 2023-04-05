package com.zestfulYoghurt.zy.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.zestfulYoghurt.zy.pojos.User;

/**
 * InterfaceName userMapper
 * Description TODO
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Mapper
public interface UserMapper {

    User select(User user);

    void insert(User user);
}
