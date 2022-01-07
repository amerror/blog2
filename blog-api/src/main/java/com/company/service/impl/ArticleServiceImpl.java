package com.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.dao.mapper.ArticleMapper;
import com.company.dao.pojo.Article;
import com.company.service.ArticleService;
import com.company.vo.ArticleVo;
import com.company.vo.Result;
import com.company.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zytwl
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 
     * @param pageParams 
     * @return
     * @author wanglin
     */
    @Override
    public Result listArticle(PageParams pageParams) {
        Page page = new Page(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getWeight, Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<Article> list = articlePage.getRecords();
        List<ArticleVo> articleVoList = copyList(list);
        return Result.success(articleVoList);
    }

    private List<ArticleVo> copyList(List<Article> list) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for(Article article : list){
            articleVoList.add(copy(article));
        }
        return articleVoList;
    }

    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if(isTag){
            Long articleVoId = articleVo.getId();
            articleVo.setTags();
        }
        if(isAuthor){
            articleVo.setAuthor();
        }
        return articleVo;
    }
}
