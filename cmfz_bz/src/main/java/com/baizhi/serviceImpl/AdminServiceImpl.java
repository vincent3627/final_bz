package com.baizhi.serviceImpl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * Created by vincent on 2018/11/12.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin findAdmin(String username, String password) {

        Admin admin = adminDao.selectByUsername(username);
        if(admin == null){
            throw new RuntimeException("该用户名不存在!");
        }else if(!admin.getPassword().equals(password)){
            throw new RuntimeException("密码错误!");
        }
        return admin;
    }

    @Transactional
    @LogAnnotation(value = "添加")
    public void addAdmin(Admin admin) {
        adminDao.insert(admin);
    }
}
