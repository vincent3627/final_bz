package com.baizhi.service;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.entity.Admin;

import javax.servlet.http.HttpSession;

/**
 * Created by vincent on 2018/11/12.
 */
public interface AdminService {
    //根据username和password查询
    Admin findAdmin(String username, String password);

    //添加
    @LogAnnotation(value = "添加")
    void addAdmin(Admin admin);
}
