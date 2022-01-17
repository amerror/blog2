package com.company.service;

import com.company.vo.Result;
import com.company.vo.params.CommentParam;

/**
 * @author zytwl
 */
public interface CommentsService {
    /**
     * 获取评论列表
     * @param id
     * @return
     * @author wanglin
     */
    Result commentsByArticleId(Long id);

    /**
     * 1
     * @param commentParam
     * @return
     * @author wanglin
     */
    Result comment(CommentParam commentParam);
}
