package com.company.service.impl;

import com.company.dao.mapper.TagMapper;
import com.company.dao.pojo.Tag;
import com.company.service.TagService;
import com.company.vo.Result;
import com.company.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zytwl
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tagsList = tagMapper.findTagsByArticleId(articleId);
        return copyList(tagsList);
    }


}
