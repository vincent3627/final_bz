package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by vincent on 2018/11/20.
 */
@Repository
public interface UserDao extends IDao<User>{
    User selectByName(String name);

    void updateStatus(@Param("id") String id, @Param("status") String status);

}
