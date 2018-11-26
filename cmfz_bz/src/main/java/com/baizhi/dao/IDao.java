package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by vincent on 2018/11/13.
 */

public interface IDao<T> {
    //插入
    void insert(T t);

    //删除
    void delete(String[] ids);

    //修改
    void update(T t);

    //分页查所有
    List<T> selectByPage(@Param("currPage") Integer currPage, @Param("pageSize") Integer pageSize);

    //查总数
    Integer selectTotal();

    //根据主键查一个
    T selectById(String id);

}
