package com.test.dao;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
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
 * Created by vincent on 2018/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class BannerTest {
    Logger logger = LoggerFactory.getLogger(BannerTest.class);

    @Autowired
    private BannerDao bannerDao;

    @Test //添加
    public void test1(){
        Banner banner = new Banner(CreateID.getId(), "测试2", "路径1", "描述1", "Y", new Date());
        bannerDao.insert(banner);
        logger.debug("banner--insert success");
    }

    @Test //分页查询
    public void test2(){
        List<Banner> bannerList = bannerDao.selectByPage(1, 3);
        for (Banner banner : bannerList) {
            logger.debug("分页查询结果:"+banner);
        }

    }

    @Test //查数据总条数
    public void test3(){
        Integer total = bannerDao.selectTotal();
        logger.debug("banner的总条数为:"+total);
    }

    @Test //修改状态--是否展示
    public void test4(){
        bannerDao.updateStatus("N","670f73b3b1824ffda1b6f7d8e4dca06c");
    }

    @Test
    public void test5(){
        String[] ids={"96e3a188431f47bbbcfcf7ade119868f"};
        bannerDao.delete(ids);
    }
}
