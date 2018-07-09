package com.hx.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/8.
 */
public class Article implements Serializable {
    private String articleId;
    private int masterId;
    private String articleName;
    private String introduction;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date articleDate;
    private String articleStatus;
    private String articleAuthor;
    private int errno;
    private List<String> data;


    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public Article(String articleId, int masterId, String articleName, String introduction, Date articleDate, String articleStatus, String articleAuthor) {
        this.articleId = articleId;
        this.masterId = masterId;
        this.articleName = articleName;
        this.introduction = introduction;
        this.articleDate = articleDate;
        this.articleStatus = articleStatus;
        this.articleAuthor = articleAuthor;
    }

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", masterId=" + masterId +
                ", articleName='" + articleName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", articleDate=" + articleDate +
                ", articleStatus='" + articleStatus + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", errno=" + errno +
                ", data=" + data +
                '}';
    }
}