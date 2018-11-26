package com.baizhi.dto;

import com.baizhi.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 2018/11/20.
 */
public class UserDTO implements Serializable{
    private List<User> rows;
    private Integer total;

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
