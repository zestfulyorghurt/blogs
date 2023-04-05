package com.zestfulYoghurt.zy.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.zestfulYoghurt.zy.pojos.Result;
import com.zestfulYoghurt.zy.tool.JsonConvert;

public class ExResolverCustom implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e)
    {
        ModelAndView mv = new ModelAndView();
        Result<String> Result = new Result<>();
        //判断接受异常的类型返回不同的错误代码和错误信息
        if (e instanceof AuthorizationException)
        {
            Result.AuthenticationError();
        }
        //把封装的返回实体bean转换为json通过response返回到前端
        PrintWriter writer = null;
        try
        {
            writer = httpServletResponse.getWriter();
            String resultJson = JsonConvert.ObjectToJson(Result);
            writer.print(resultJson);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return mv;
    }

}
