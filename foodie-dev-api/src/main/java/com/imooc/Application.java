package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

import java.sql.SQLOutput;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
@ComponentScan(basePackages="com.imooc")
//45
public class Application {
    public static void main(String[] args) {
        System.out.println("two");
        SpringApplication.run(Application.class,args);
    }
}
