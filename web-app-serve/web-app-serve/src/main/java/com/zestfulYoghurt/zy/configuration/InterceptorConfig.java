package com.zestfulYoghurt.zy.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zestfulYoghurt.zy.Interceptor.TokenInterceptor;

public class InterceptorConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
    	//注册拦截器放行的url
    	ArrayList<String> patterns = new ArrayList<String>();
    	patterns.add("/login");patterns.add("/regist");
        registry
            .addInterceptor(TokenVerification())
            .addPathPatterns("/**")
            .excludePathPatterns(patterns);
    }

    @Bean
    public TokenInterceptor TokenVerification(){
        return new TokenInterceptor();
    }

}
