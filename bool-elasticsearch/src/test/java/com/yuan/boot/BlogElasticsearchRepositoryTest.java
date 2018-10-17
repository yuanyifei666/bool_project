package com.yuan.boot;

import com.yuan.boot.domain.Blog;
import com.yuan.boot.repository.BlogElasticsearchRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试BlogElasticsearchRespository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogElasticsearchRepositoryTest {

    @Autowired
    private BlogElasticsearchRepository repository;

    @Before //在执行@Test注解前先之执行该方法
    public void init(){
        // 清空所有
        repository.deleteAll();

        repository.save(new Blog("1","老卫跟你谈谈安装 Elasticsearch",
                "关于如何来安装 Elasticsearch，这个请看我的博客 https://waylau.com"));
        repository.save(new Blog("2","老卫跟你谈谈 Elasticsearch 的几个用法",
                "关于如何来用 Elasticsearch，还是得看我的博客 https://waylau.com，妹"));  // 关键字"妹"
        repository.save(new Blog("3","老卫和你一起学 Elasticsearch",
                "如何来学习 Elasticsearch，最终看我的博客 https://waylau.com，酒")); // 关键字"酒"

        repository.save(new Blog("4","03-05 用大白话聊聊分布式系统",
                "一提起“分布式系统”，大家的第一感觉就是好高大上啊，深不可测"));
        repository.save(new Blog("5","02-19 Thymeleaf 3 引入了新的解析系统",
                "如果你的代码使用了 HTML5 的标准，而Thymeleaf 版本来停留在 2.x ，那么如果没有把闭合"));
        repository.save(new Blog("6","02-19 使用 GFM Eclipse 插件时，不在项目里面生成 HTML 文件",
                "GFM 是 GitHub Flavored Markdown Viewer 的简称，是一款对 GitHub 友好的 Markdown 编辑器 。"));

    }

    @Test
    public void search(){
        //定义搜索的条件
        String content = "妹";
        String description = "酒";
        Pageable pageable = new PageRequest(0,10);

        Page page = repository.findDistinctBlogByContentOrDescription(content, description, pageable);
        long total = page.getTotalElements();
        System.out.println("匹配的所有总记录数："+total);
        List<Blog> blogs = page.getContent();

        System.out.println("==================start search==============");
        //打印分页的前10条数据
        for (Blog blog: blogs) {
            System.out.println(blog);
        }



    }


}
