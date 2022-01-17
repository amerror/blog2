package com.company.service;

import com.company.vo.CategoryVo;
import com.company.vo.Result;

import java.util.List;

/**
 * @author zytwl
 */
public interface CategoryService {
    /**
     * 通过分类ID查找
     * @param categoryId
     * @return
     * @author wanglin
     */
    CategoryVo findCategoryById(Long categoryId);

    /**
     * 找到所有的类别
     * @param
     * @return
     * @author wanglin
     */
    Result findAll();

}
