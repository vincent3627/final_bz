package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 2018/11/18.
 */
public class Guru implements Serializable {
    private String id;
    private String name;
    private String dharmaName;
    private String status;
    private String phoneNum;
    private String photoImg;
    private List<Article> children;

    public Guru() {
    }

    public Guru(String id, String name, String dharmaName, String status, String phoneNum, String photoImg) {

        this.id = id;
        this.name = name;
        this.dharmaName = dharmaName;
        this.status = status;
        this.phoneNum = phoneNum;
        this.photoImg = photoImg;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhotoImg() {
        return photoImg;
    }

    public void setPhotoImg(String photoImg) {
        this.photoImg = photoImg;
    }

    public List<Article> getChildren() {
        return children;
    }

    public void setChildren(List<Article> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", status='" + status + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", photoImg='" + photoImg + '\'' +
                ", children=" + children +
                '}';
    }
}
