package com.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.dao.dos.Archives;
import com.company.dao.mapper.ArticleBodyMapper;
import com.company.dao.mapper.ArticleMapper;
import com.company.dao.pojo.Article;
import com.company.dao.pojo.ArticleBody;
import com.company.service.ArticleService;
import com.company.service.CategoryService;
import com.company.service.SysUserService;
import com.company.service.TagService;
import com.company.vo.ArticleBodyVo;
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
    @Autowired
    private TagService tagService;
    @Autowired
    private SysUserService sysUserService;

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
        List<ArticleVo> articleVoList = copyList(list,true,true);
        return Result.success(articleVoList);
    }

    @Override
    public Result hotArticle(int limit) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.last("limit "+limit);
        List<Article> articleList = articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articleList,false,false));
    }

    @Override
    public Result newArticle(int limit) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.orderByDesc(Article::getCommentCounts);
        queryWrapper.last("limit "+limit);
        List<Article> articleList = articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articleList,false,false));
    }

    @Override
    public Result listArchives() {
        List<Archives> list = articleMapper.listArchives();
        return Result.success(list);
    }

    @Override
    public Result findArticleById(Long id) {
        Article article = this.articleMapper.selectById(id);
        ArticleVo articleVo = copy(article, true, true,true,true);
        return Result.success(articleVo);
    }

    private List<ArticleVo> copyList(List<Article> list,boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for(Article article : list){
            articleVoList.add(copy(article,isTag, isAuthor,false,false));
        }
        return articleVoList;
    }
    private List<ArticleVo> copyList(List<Article> list,boolean isTag, boolean isAuthor,boolean isBody, boolean isCategory) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for(Article article : list){
            articleVoList.add(copy(article,isTag, isAuthor,isBody,isCategory));
        }
        return articleVoList;
    }

    @Autowired
    private CategoryService categoryService;
    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        /**
         * 因为articleVo里面的属性有文章的标签和作者信息，但是article只有id的信息，
         * 所以需要多表查询得出文章id和作者id对应的信息，然后赋给articleVo中,
         * 所以下面获取的id都是从原类型article中获取，Vo中是没有这些属性的。
         */
        if(isTag){
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }
        if(isAuthor){
            Long authorId = article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserById(authorId).getNickname());
        }
        if (isBody) {
            Long bodyId = article.getBodyId();
            articleVo.setBody(findArticleBodyById(bodyId));

        }
        if (isCategory) {
            Long categoryId = article.getCategoryId();
            articleVo.setCategory(categoryService.findCategoryById(categoryId));
        }
        return articleVo;
    }

    @Autowired
    private ArticleBodyMapper articleBodyMapper;
    private ArticleBodyVo findArticleBodyById(Long bodyId) {
        ArticleBody articleBody = articleBodyMapper.selectById(bodyId);
        ArticleBodyVo articleBodyVo = new ArticleBodyVo();
        articleBodyVo.setContent(articleBody.getContent());
        return articleBodyVo;
    }
}
