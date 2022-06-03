package com.zestfulYoghurt.zy.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebFault;
import java.io.IOException;

@WebFilter(filterName = "CorsFilter")
@Configuration
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        //HttpServletResponse和ServletResponse之间的区别 todo
//        HttpServletResponse response =  (HttpServletResponse) servletResponse;
//
//        //Access-Control-Allow-Origin,*表示所有的域,*可以使用具体的url来代替,表示只可以解决指定的域名跨域
//        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
//
//        //设置跨域证书为true todo 设置为false看是否能解决跨域问题
//        response.setHeader("Access-Control-Allow-Credentials","true");
//
//        //设置请求的方式
//        response.setHeader("Access-Control-Allow-Methods","POST,GET,PATCH,DELETE,PUT");
//
//        //跨域检测的有效时间,浏览器跨域请求会有两次请求，首先浏览器使用OPTIONS方法发起一个预检请求，第二次才是异步处理请求
//        //Access-Control-Max-Age是设置异步连接的有效性，也就是浏览器第一次请求的发送时间，以秒为单位
//        response.setHeader("Access-Control-Max-Age","3600");
//
//        //不知到有什么用 设置响应头中的参数
//        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept,Authorization");
//
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }

}
