package com.baizhi.dao;

import com.baizhi.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vincent on 2018/11/12.
 */
@Repository
public interface MenuDao {

    List<Menu> selectMenu();
}
