package com.baizhi.service;

import com.baizhi.dto.UserDTO;
import com.baizhi.entity.User;

/**
 * Created by vincent on 2018/11/20.
 */
public interface UserService {
    //登录
    User findByNameAndPassword(String name, String password);

    //注册
    void addUser(User user);

    //分页展示
    UserDTO findByPage(Integer currPage, Integer pageSize);

    //修改状态
    void modifyStatus(String id, String status);
}
