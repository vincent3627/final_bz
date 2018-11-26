package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by vincent on 2018/11/18.
 */
public class Article implements Serializable{
    private String id;
    private String title;
    private String insertImg;
    private String content;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String guruId;

    public Article() {
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInsertImg() {
        return insertImg;
    }

    public void setInsertImg(String insertImg) {
        this.insertImg = insertImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", insertImg='" + insertImg + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", createDate=" + createDate +
                ", guruId='" + guruId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) &&
                Objects.equals(title, article.title) &&
                Objects.equals(insertImg, article.insertImg) &&
                Objects.equals(content, article.content) &&
                Objects.equals(publishDate, article.publishDate) &&
                Objects.equals(createDate, article.createDate) &&
                Objects.equals(guruId, article.guruId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, insertImg, content, publishDate, createDate, guruId);
    }
}
