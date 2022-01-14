package com.company.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.company.dao.mapper.ArticleMapper;
import com.company.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zytwl
 */
@Component
public class ThreadService {
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {
        int viewCount = article.getViewCounts();
        Article articleUpdata = new Article();
        articleUpdata.setViewCounts(viewCount);
        LambdaUpdateWrapper<Article> lambdaUpdateWrapper = new LambdaUpdateWrapper();
        lambdaUpdateWrapper.eq(Article::getId,article.getId());
        lambdaUpdateWrapper.eq(Article::getViewCounts,viewCount);
        articleMapper.update(articleUpdata,lambdaUpdateWrapper);
    }
}
