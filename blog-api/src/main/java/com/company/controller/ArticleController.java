package com.company.controller;

import com.company.service.ArticleService;
import com.company.vo.Result;
import com.company.vo.params.ArticleParam;
import com.company.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

/**
 * @author zytwl
 */
@RestController
@RequestMapping("articles")
public class ArticleController {
    //8628d1f407f72e10ac947a032fe5ad29
    @Autowired
    private ArticleService articleService;
    /**
     * 首页 文章列表
     * @param pageParams
     * @return
     * @author wanglin
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    /**
     * 首页最热文章
     * @param
     * @return
     * @author wanglin
     */
    @PostMapping("hot")
    public Result hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    /**
     *首页最新文章
     * @param
     * @return
     * @author wanglin
     */
    @PostMapping("new")
    public Result newArticle(){
        int limit = 5;
        return articleService.newArticle(limit);
    }
    @PostMapping("listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long id){
        return articleService.findArticleById(id);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }

}
