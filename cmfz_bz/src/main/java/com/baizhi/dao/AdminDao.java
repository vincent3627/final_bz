package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by vincent on 2018/11/12.
 */
@Repository
public interface AdminDao extends IDao<Admin>{
    //根据username查询
    Admin selectByUsername(String username);
}
