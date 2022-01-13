package com.company.service.impl;

import com.company.dao.mapper.TagMapper;
import com.company.dao.pojo.Tag;
import com.company.service.TagService;
import com.company.vo.Result;
import com.company.vo.TagVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public Result hot(int limit) {
        List<Long> tagsIds = tagMapper.findHotsTagIds(limit);
        if(CollectionUtils.isEmpty(tagsIds)){
            return Result.success(Collections.EMPTY_LIST);
        }
        List<Tag> tagsList = tagMapper.findTagsByTagIds(tagsIds);
        return Result.success(tagsList);
    }

    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> list = new ArrayList<>();
        for(Tag tag : tagList){
            list.add(copy(tag));
        }
        return list;
    }

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }


}
