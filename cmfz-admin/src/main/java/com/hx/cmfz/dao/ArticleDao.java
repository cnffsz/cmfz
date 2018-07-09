package com.hx.cmfz.dao;

import com.hx.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface ArticleDao {
    public List<Article> selectArticle(@Param("begin") int begin, @Param("showSize") int showSize);
    public int countArticle();
    public boolean insertArticle(Article article);
    public boolean updateArticle(Article article);
    public boolean deleteArticle(Article article);
}
