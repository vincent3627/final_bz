package com.baizhi.serviceImpl;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vincent on 2018/11/12.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryMenu() {
        List<Menu> menuList = menuDao.selectMenu();
        return menuList;
    }
}
