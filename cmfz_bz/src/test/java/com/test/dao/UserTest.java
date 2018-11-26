package com.test.dao;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.CreateID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2018/11/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class UserTest {

    private Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Autowired
    private UserDao userDao;

    @Test //根据name查询
    public void test1(){
        User bobo = userDao.selectByName("bobo");
        logger.debug("根据name查询的User为:"+bobo);
    }

    @Test //插入
    public void test2(){
        User user = new User();
        user.setId(CreateID.getId());
        user.setName("xuke");
        user.setDharmaName("法号-xuke");
        user.setSex("女");
        user.setProvince("广东");
        user.setCity("深圳");
        user.setSign("我眺望远方的天空");
        user.setSalt("xuke");
        user.setPhoneNum("13190909090");
        user.setGuruId("2184f7c1229e49c2a85d5dd0eeb59c85");
        user.setPassword("777777");
        user.setStatus("Y");
        user.setRegistDate(new Date());

        userDao.insert(user);
    }

    @Test //分页查询
    public void test3(){
        List<User> users = userDao.selectByPage(1, 3);
        for (User user : users) {
            logger.debug("分页查询的user为:"+user);
        }
    }

    @Test //查数据中条数
    public void test4(){
        Integer total = userDao.selectTotal();
        logger.debug("user表中的数据总条数:"+total);
    }

    @Test //修改状态
    public void test5(){
        userDao.updateStatus("28370bdcfa084585a19a7112344fb29d","N");
    }

}
