package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by vincent on 2018/11/12.
 */
public class Admin implements Serializable{
    private String id;
    private String username;
    private String password;
    private String privilege;
    private String rank;

    public Admin() {
    }

    public Admin(String id, String username, String password, String privilege, String rank) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.privilege = privilege;
        this.rank = rank;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privilege='" + privilege + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
