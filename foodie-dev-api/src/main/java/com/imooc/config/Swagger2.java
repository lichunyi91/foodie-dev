package com.imooc.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class Swagger2 {

    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().
                apis((RequestHandlerSelectors.basePackage("com.imooc.controller"))).paths(PathSelectors.any()).build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("电商平台接口api").contact(new Contact("imooc", "https://www.imooc.com", "abc@imooc.com")).
                description("专为天天吃货提供的api文档").version("1.0.1").termsOfServiceUrl("https://www.imooc.com").build();
    }
}
