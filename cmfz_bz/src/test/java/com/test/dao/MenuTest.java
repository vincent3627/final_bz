package com.test.dao;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by vincent on 2018/11/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class MenuTest {
    Logger logger = LoggerFactory.getLogger(MenuTest.class);
    @Autowired
    private MenuDao menuDao;
    @Test
    public void test1(){
        List<Menu> menus = menuDao.selectMenu();
        for (Menu menu : menus) {
           logger.debug("menu:"+menu);
        }
    }
}
