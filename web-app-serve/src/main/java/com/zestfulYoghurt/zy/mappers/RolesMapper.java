package com.zestfulYoghurt.zy.mappers;

import com.zestfulYoghurt.zy.pojos.basePojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface RolesMapper {

    //根据角色id查询角色
    public Set<Role> select(@Param("role_id") String[] role_id);

}
