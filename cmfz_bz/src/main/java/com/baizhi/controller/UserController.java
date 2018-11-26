package com.baizhi.controller;

import com.baizhi.dto.UserDTO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by vincent on 2018/11/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/regist")
    public String regist(User user){
        userService.addUser(user);
        return "index";
    }

    @RequestMapping("/login")
    public String login(String name,String password,HttpSession session){
        User user = userService.findByNameAndPassword(name, password);
        session.setAttribute("login","success");
        session.setAttribute("user",user);
        return "main";
    }

    @RequestMapping("/showByPage")
    @ResponseBody
    public UserDTO showByPage(Integer rows,Integer page){
        UserDTO userDTO = userService.findByPage(page, rows);
        return userDTO;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public void edit(String id,String status){
        userService.modifyStatus(id, status);
    }

}
