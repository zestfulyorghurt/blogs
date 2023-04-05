package com.zestfulYoghurt.zy.tool;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.zestfulYoghurt.zy.pojos.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUtil {

    private String salt;
    private long ttl;

    public static String createJWT(User user){
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        HashMap<String,Object> map = new HashMap<String,Object>();
        JwtBuilder builder =  Jwts.builder()
        		      //.setId(id)
                      //.setSubject(subject)
        		      .setClaims(map)
                      .setIssuedAt(now)
                      //.setExpiration(new Date(System.currentTimeMillis() + 30*1000)) //设置jwt过期时间
                      .signWith(SignatureAlgorithm.HS256,"admin");
        return builder.compact();

    }

    public static Claims parseJWT(String jwtStr){
        return Jwts.parser()
                   .setSigningKey("admin")
                   .parseClaimsJws(jwtStr)
                   .getBody();
    }

}
