package com.company.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.dao.dos.Archives;
import com.company.dao.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zytwl
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();
}
