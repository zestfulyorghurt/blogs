package com.zestfulYoghurt.zy.Interceptor;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zestfulYoghurt.zy.pojos.Result;
import com.zestfulYoghurt.zy.tool.JsonConvert;
import com.zestfulYoghurt.zy.tool.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

public class TokenInterceptor implements HandlerInterceptor {

	Result<Object> result;

    @Override
    public boolean preHandle(HttpServletRequest request,
    		HttpServletResponse response,
    		Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if(token == null){
        	outputCustom(request,response);
            return false;
        }else{
          try{
        	  //TODO
        	  //先看缓存数据库里边有没有token
        	  //如果没有，直接没有登陆，引导用户重新登录
        	  //如果有，解析jwt，
        	  //如果异常，token失效，引导用户重新
        	  JwtUtil.parseJWT(token);
          }catch(ExpiredJwtException e){
        	  outputCustom(request,response);
        	  return false;
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

    public void outputCustom(HttpServletRequest request,
    		HttpServletResponse response)
    {
    	try{
        	PrintWriter out = response.getWriter();
        	result = new Result<>();
        	result.AuthenticationError();
            String resultJson = JsonConvert.ObjectToJson(result);
            out.println(resultJson);
            out.flush();
            out.close();
    	}catch(Exception ex){

    	}
    }
}
