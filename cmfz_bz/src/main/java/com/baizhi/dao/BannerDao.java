package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vincent on 2018/11/12.
 */
@Repository
public interface BannerDao extends IDao<Banner>{
    //改状态
    void updateStatus(@Param("status") String status, @Param("id") String id);

}
