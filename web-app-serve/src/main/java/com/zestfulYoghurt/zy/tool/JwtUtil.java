package com.zestfulYoghurt.zy.tool;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUtil {

    //定义盐
    private String salt;

    //定义token过期时间
    private long ttl;

    //创建token
    public String createJWT(String id,String subject,String roles){

        //获取当前时间
        long nowMillis = System.currentTimeMillis();

        Date now = new Date(nowMillis);

        JwtBuilder builder =  Jwts.builder().setId(id)
                      .setSubject(subject)
                      .setIssuedAt(now)
                      .signWith(SignatureAlgorithm.HS256,"admin")
                      .claim("roles",roles);

        if(ttl > 0){

            //设置到期时间
            builder.setExpiration(new Date(nowMillis + ttl));

        }

        return builder.compact();

    }

    //解析token
    public Claims parseJWT(String jwtStr){

        return Jwts.parser()
                   .setSigningKey("admin")
                   .parseClaimsJws(jwtStr)
                   .getBody();

    }

}
