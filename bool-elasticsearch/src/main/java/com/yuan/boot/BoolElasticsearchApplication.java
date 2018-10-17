package com.yuan.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //开启swagger功能
public class BoolElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoolElasticsearchApplication.class, args);
    }
}
