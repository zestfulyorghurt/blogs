package com.zestfulYoghurt.zy;

import com.zestfulYoghurt.zy.common.ExResolverCustom;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.zestfulYoghurt.zy.mappers")
public class ZyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyApplication.class, args);
    }

    // 注册统一异常处理bean
    @Bean
    public ExResolverCustom myExceptionResolver() {
        return new ExResolverCustom();
    }
}
