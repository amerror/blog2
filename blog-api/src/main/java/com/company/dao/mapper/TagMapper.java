package com.company.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.dao.pojo.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zytwl
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {
    /**
     *通过文章ID找标签
     * @param articleId
     * @return
     * @author wanglin
     */
    List<Tag> findTagsByArticleId(Long articleId);

    /**
     * 查找热门标签
     * @param limit
     * @return
     * @author wanglin
     */
    List<Long> findHotsTagIds(int limit);

    /**
     *通过tagid数组获取相应的tag信息
     * @param tagsIds
     * @return
     * @author wanglin
     */
    List<Tag> findTagsByTagIds(List<Long> tagsIds);
}
