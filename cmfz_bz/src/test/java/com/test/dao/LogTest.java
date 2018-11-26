package com.test.dao;

import com.baizhi.dao.LogDao;
import com.baizhi.entity.Log;
import com.baizhi.util.CreateID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class LogTest {
    @Autowired
    private LogDao logDao;
    @Test  //插入
    public void test1(){
        Log log = new Log(CreateID.getId(), "xuke", new Date(), "添加", true);
        logDao.insert(log);
    }

}
