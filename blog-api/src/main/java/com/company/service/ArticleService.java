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
}
