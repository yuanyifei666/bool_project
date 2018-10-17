package com.yuan.boot.repository;

import com.yuan.boot.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作elasticsearch的数据访问层
 */
@Repository
public interface BlogElasticsearchRepository extends ElasticsearchRepository<Blog,String> {

    /**
     * 通过title和content和description的内容进行关键字查询
     */
    public Page findDistinctBlogByContentOrDescription( String content, String description, Pageable pageable);

}
