package com.zestfulYoghurt.zy.handlerInterceptor;


import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.tool.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 对前端在请求头中的token进行验证
 */
@Component
@Slf4j
public class TokenVerification implements HandlerInterceptor {



    @Autowired
    UserMapper userMapper;
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<String, String[]> parameterMap = request.getParameterMap();

        String token = request.getHeader("Authorization");

        if(token == null){

            log.warn("还没有登录，请登录");

            return true;

        }else{

          try{

              Claims claims = jwtUtil.parseJWT(token);

          }catch(ExpiredJwtException e){

              log.error("token过期了");

          }

        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
