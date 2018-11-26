package com.baizhi.dto;

import com.baizhi.entity.Banner;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 2018/11/12.
 */
public class BannerDTO implements Serializable{
    private List<Banner> rows;
    private Integer total;

    public List<Banner> getRows() {
        return rows;
    }

    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
