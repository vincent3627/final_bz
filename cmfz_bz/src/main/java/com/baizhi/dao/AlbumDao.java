package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by vincent on 2018/11/14.
 */
@Repository
public interface AlbumDao extends IDao<Album>{
    //更新数量
    void updateCount(@Param("id") String id, @Param("count") Integer count);
}
