package com.zestfulYoghurt.zy.mappers;

import com.zestfulYoghurt.zy.pojos.basePojo.Permissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface PermissionsMapper {

    //根据权限id查询权限
    public Set<Permissions> select(@Param("permission_id") String[] permission_id);

}
