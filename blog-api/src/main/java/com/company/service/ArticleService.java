package com.company.service;

import com.company.vo.Result;
import com.company.vo.params.PageParams;
import org.springframework.stereotype.Service;

/**
 * @author zytwl
 */

public interface ArticleService {
    /**
     * 分页查询 文章列表
     * @param pageParams 
     * @return 
     * @author wanglin
     */
    Result listArticle(PageParams pageParams);

    /**
     * 查找前limit的最热文章
     * @param limit
     * @return
     * @author wanglin
     */
    Result hotArticle(int limit);

    /**
     *查找最新的文章
     * @param limit
     * @return
     * @author wanglin
     */
    Result newArticle(int limit);

    /**
     * 文章归档
     * @param  
     * @return 
     * @author wanglin
     */
    Result listArchives();

    /**
     * 查询文章详情
     * @param id
     * @return
     * @author wanglin
     */
    Result findArticleById(Long id);
}
