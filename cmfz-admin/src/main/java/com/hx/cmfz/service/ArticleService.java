package com.hx.cmfz.service;

import com.hx.cmfz.entity.Article;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface ArticleService {

    public Map<String,Object> queryArticle(int totalSize, int pageIndex);
    public boolean addArticle(Article article);
    public boolean modifyArticle(Article article);

}
