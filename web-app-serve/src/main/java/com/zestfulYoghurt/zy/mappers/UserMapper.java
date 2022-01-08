package com.zestfulYoghurt.zy.mappers;

import com.zestfulYoghurt.zy.pojos.basePojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * InterfaceName userMapper
 * Description TODO
 * Author ZestfulYoghurt
 * Date 2021/06/02 2021.6.2
 * Version 1.0
 **/
@Mapper
public interface UserMapper {

    List<User> select(User user);

    void insert(User user);
}
