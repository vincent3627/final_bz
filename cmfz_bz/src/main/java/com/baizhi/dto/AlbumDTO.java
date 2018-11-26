package com.baizhi.dto;

import com.baizhi.entity.Album;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 2018/11/14.
 */
public class AlbumDTO implements Serializable{
    private List<Album> rows;
    private Integer total;

    @Override
    public String toString() {
        return "AlbumDTO{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }

    public List<Album> getRows() {
        return rows;
    }

    public void setRows(List<Album> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
