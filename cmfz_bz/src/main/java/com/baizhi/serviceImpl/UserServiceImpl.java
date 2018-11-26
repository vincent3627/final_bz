package com.baizhi.serviceImpl;

import com.baizhi.dao.UserDao;
import com.baizhi.dto.UserDTO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2018/11/20.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findByNameAndPassword(String name, String password) {
        try {
            User user = userDao.selectByName(name);
            if (user == null){
                throw new RuntimeException("该用户名不存在!");
            }
            String salt = user.getSalt();
            String inputPwd = salt+password;
            String s = DigestUtils.md5Hex(inputPwd);
            if(!user.getPassword().equals(s)){
                throw new RuntimeException("密码输入错误!");
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public void addUser(User user) {
        user.setRegistDate(new Date());
        //私盐加密
        String salt = user.getName();
        String password = DigestUtils.md5Hex(salt+user.getPassword());
        user.setPassword(password);

        userDao.insert(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public UserDTO findByPage(Integer currPage, Integer pageSize) {
        List<User> userList = userDao.selectByPage(currPage, pageSize);
        Integer total = userDao.selectTotal();

        UserDTO userDTO = new UserDTO();
        userDTO.setRows(userList);
        userDTO.setTotal(total);
        return userDTO;
    }

    @Transactional
    public void modifyStatus(String id, String status) {
         userDao.updateStatus(id, status);
    }
}
