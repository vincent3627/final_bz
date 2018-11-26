package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by vincent on 2018/11/19.
 */
public class Task implements Serializable{
    private String id;
    private String title;
    private String mark;
    private User user;

    public Task() {
    }

    public Task(String id, String title, String mark, User user) {

        this.id = id;
        this.title = title;
        this.mark = mark;
        this.user = user;
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", mark='" + mark + '\'' +
                ", user=" + user +
                '}';
    }
}
