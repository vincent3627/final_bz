package com.test.dao;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import com.baizhi.util.CreateID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by vincent on 2018/11/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class GuruTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired 
    private GuruDao guruDao;
    
    @Test //插入
    public void test1(){

        Guru guru = new Guru(CreateID.getId(), "5狗", "yuan通", "Y", "13110101010", "/guru/photo");
        guruDao.insert(guru);
    }

    @Test //分页查
    public void test2(){
        List<Guru> gurus = guruDao.selectByPage(2, 3);
        for (Guru guru : gurus) {
            logger.debug("分页查到的Guru:"+guru);
        }
    }

    @Test //数据条数
    public void test3(){
        Integer total = guruDao.selectTotal();
        logger.debug("guru表的数据条数:"+total);
    }

    @Test //删除
    public void test4(){
        String[] ids={"cc8eed95c74b4713ad64be2ee46218b3"};
        guruDao.delete(ids);
    }

}
