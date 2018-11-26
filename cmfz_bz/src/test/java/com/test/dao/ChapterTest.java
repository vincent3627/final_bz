package com.test.dao;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.util.CreateID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by vincent on 2018/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class ChapterTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ChapterDao chapterDao;

    @Test //插入
    public void test1() {
        Chapter chapter = new Chapter(CreateID.getId(), "test--title", "5fen", "1MB", "/haha/hehe", "23ed9cc4262642af937ceca2b50332f7",new Date());
        chapterDao.insert(chapter);
    }

    @Test //对应专辑的章节数
    public void test2(){
        Integer count = chapterDao.selectCountByPid("23ed9cc4262642af937ceca2b50332f7");
        logger.debug("对应专辑的章节数:"+count);
    }

    @Test //修改
    public void test3(){
        Chapter chapter = new Chapter("94dfa19075024a5d9d0d798769227e14", "test--update", "update", "3MB", "/update/hehe", "23ed9cc4262642af937ceca2b50332f7",new Date());
        chapterDao.update(chapter);
    }

}