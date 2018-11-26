package com.baizhi.controller;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by vincent on 2018/11/12.
 */
@RestController
@RequestMapping("/code")
public class ValidateCodeController {
    @RequestMapping("/createCode")
    public  void createValidateCode(HttpSession session, HttpServletResponse response) throws IOException {
        String securityCode = SecurityCode.getSecurityCode();
        BufferedImage image = SecurityImage.createImage(securityCode);
        //将生成的验证码存入 session
        session.setAttribute("validateCode",securityCode);
        ServletOutputStream outputStream = response.getOutputStream();
        //使用输出流将验证码图片输出到页面
        ImageIO.write(image,"png",outputStream);
    }

}
