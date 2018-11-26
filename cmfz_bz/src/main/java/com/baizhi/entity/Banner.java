package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by vincent on 2018/11/12.
 */
public class Banner implements Serializable{
    private String id;
    private String title;
    private String imgPath;
    private String description;
    private String status;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date uploadDate;

    public Banner() {
    }

    public Banner(String id, String title, String imgPath, String description, String status, Date uploadDate) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.uploadDate = uploadDate;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banner)) return false;
        Banner banner = (Banner) o;
        return Objects.equals(getId(), banner.getId()) &&
                Objects.equals(getTitle(), banner.getTitle()) &&
                Objects.equals(getImgPath(), banner.getImgPath()) &&
                Objects.equals(getDescription(), banner.getDescription()) &&
                Objects.equals(getStatus(), banner.getStatus()) &&
                Objects.equals(getUploadDate(), banner.getUploadDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getImgPath(), getDescription(), getStatus(), getUploadDate());
    }
}
