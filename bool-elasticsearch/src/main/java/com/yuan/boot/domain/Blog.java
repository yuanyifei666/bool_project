package com.yuan.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 博客文章的实体
 */

@Document(indexName = "blog",type = "Blog") //该注解表示该实体为elasticsearch  的文档类
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {

    @Id
    private String title;
    private String content;
    private String description;

}
