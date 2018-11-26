package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.springframework.stereotype.Repository;

/**
 * Created by vincent on 2018/11/14.
 */
@Repository
public interface ChapterDao extends IDao<Chapter>{
    //根据外键查数量
    Integer selectCountByPid(String Pid);

}
