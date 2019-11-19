package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    public CorsConfig() {
    }
    @Bean
    public CorsFilter conrsFilter(){
        //添加cors配置信息
        CorsConfiguration configuration=new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8080");
        //设置是否发送cookie
        configuration.setAllowCredentials(true);
        //设置允许请求的方式
        configuration.addAllowedMethod("*");
        //设置允许的header
        configuration.addAllowedHeader("*");
        //为url添加映射路径
        UrlBasedCorsConfigurationSource source =new  UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);



    }

}
