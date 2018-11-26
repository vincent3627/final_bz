package com.test.dao;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.CreateID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vincent on 2018/11/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class AdminTest {
    Logger logger = LoggerFactory.getLogger(AdminTest.class);
    @Autowired
    private AdminDao adminDao;

    @Test //根据username查
    public void test1(){
        Admin admin = adminDao.selectByUsername("admin");
        logger.debug("查询到的管理员:"+admin);
    }

    @Test //添加
    public void test2(){
        Admin admin = new Admin();
        admin.setId(CreateID.getId());
        admin.setUsername("xuke");
        admin.setPassword("666666");
        adminDao.insert(admin);
    }
}
