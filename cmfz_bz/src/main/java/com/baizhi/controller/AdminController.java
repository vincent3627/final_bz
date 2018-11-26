package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by vincent on 2018/11/12.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String username, String password,HttpSession session,String enCode){
        String validateCode = (String) session.getAttribute("validateCode");
        if (!validateCode.equalsIgnoreCase(enCode)){
            throw new RuntimeException("验证码输入错误!");
        }
        Admin admin = adminService.findAdmin(username, password);
        session.setAttribute("username",username);
        session.setAttribute("admin",admin);
        return "redirect:/view/main/main.jsp";
    }

    @RequestMapping("/exit")
    public String safeExit(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/view/main/login.jsp";
    }


    @RequestMapping("/add")
    public void addAdmin(Admin admin,HttpSession session){
        adminService.addAdmin(admin);
        session.setAttribute("admin",admin.getUsername());
    }
}
