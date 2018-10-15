package com.yuan.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2的配置文件
 */
@Configuration
public class MySwagger2Config {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.yuan.boot.controller"))
                    .paths(PathSelectors.any())
                    .build(); //构建docket对象
    }
    //定义Swaggerapi的相关信息
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("使用swagger2 来编写开发的api的文档")
                .description("简单优雅的restfun风格，http://blog-project/index")
                .version("2.0")
                .build();
    }
}
