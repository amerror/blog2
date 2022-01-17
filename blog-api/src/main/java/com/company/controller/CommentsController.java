package com.company.controller;

import com.company.service.CommentsService;
import com.company.vo.Result;
import com.company.vo.params.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

/**
 * @author zytwl
 */
@RestController
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("article/{id}")
    public Result comments(@PathVariable("id") Long id){
        return commentsService.commentsByArticleId(id);
    }

    @PostMapping("create/change")
    public Result Comment(@RequestBody CommentParam commentParam){
        return commentsService.comment(commentParam);
    }
}
