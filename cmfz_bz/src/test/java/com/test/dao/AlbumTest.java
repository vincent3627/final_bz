package com.test.dao;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
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
 * Created by vincent on 2018/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class AlbumTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AlbumDao albumDao;

    @Test //插入
    public void test1(){
        Album album = new Album();
        album.setId("test---id");
        album.setTitle("test---title");
        album.setCount(121);
        album.setCorverImg("test/path");
        album.setScore(10.0);
        album.setAuthor("author--二师兄");
        album.setBroadCast("清音");
        album.setBrife("test---简介");
        album.setPublicDate(new Date());
        album.setCreateDate(new Date());
        album.setStatus("Y");

        albumDao.insert(album);
    }

    @Test //根据主键查
    public void test2(){
        Album album = albumDao.selectById("23ed9cc4262642af937ceca2b50332f7");
        logger.debug("根据主键查到的专辑:"+album);
    }

    @Test //分页查所有
    public void test3(){
        List<Album> albums = albumDao.selectByPage(1, 10);
        for (Album album : albums) {
            logger.debug("分页查到的专辑:"+album);
        }
    }

    @Test //查总数
    public void test4(){
        Integer total = albumDao.selectTotal();
        logger.debug("专辑的总数量:"+total);
    }

    @Test //根据id查询
    public void test5(){
        Album album = albumDao.selectById("23ed9cc4262642af937ceca2b50332f7");
        logger.debug("根据id查询Album:"+album);
    }
}

