package com.zestfulYoghurt.zy;

import com.zestfulYoghurt.zy.tool.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class TEST {

    @Test
    public void testToken(){

        Long ttl = 1000L;

        JwtUtil jwtUtil = new JwtUtil("Zest",ttl);

        String jwt = jwtUtil.createJWT("1", "sj", "admin");

        System.out.println(jwt);

        Claims claims = jwtUtil.parseJWT(jwt);

        System.out.println(claims);

    }

}
