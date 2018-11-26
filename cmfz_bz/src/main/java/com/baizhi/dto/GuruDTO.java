package com.baizhi.dto;

import com.baizhi.entity.Guru;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 2018/11/20.
 */
public class GuruDTO implements Serializable{
    private List<Guru> rows;
    private Integer total;

    @Override
    public String toString() {
        return "GuruDTO{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }

    public List<Guru> getRows() {
        return rows;
    }

    public void setRows(List<Guru> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
