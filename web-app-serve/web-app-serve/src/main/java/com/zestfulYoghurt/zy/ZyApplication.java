package com.zestfulYoghurt.zy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zestfulYoghurt.zy.mappers")
public class ZyApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZyApplication.class, args);

    }

}
