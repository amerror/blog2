package com.company.service;

import com.company.vo.Result;
import com.company.vo.TagVo;

import java.util.List;

/**
 * @author zytwl
 */
public interface TagService {
    /**
     *查找标签对应的文章
     * @param articleId
     * @return
     * @author wanglin
     */
    List<TagVo> findTagsByArticleId(Long articleId);

    /**
     * 热门标签
     * @param limit
     * @return
     * @author wanglin
     */
    Result hot(int limit);

    /**
     * 查询所有的标签
     * @param
     * @return
     * @author wanglin
     */
    Result findAll();


}
