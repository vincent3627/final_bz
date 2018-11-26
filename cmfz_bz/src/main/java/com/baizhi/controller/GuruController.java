package com.baizhi.controller;

import com.baizhi.dto.GuruDTO;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vincent on 2018/11/20.
 */
@RestController
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/upload")
    public void uploadGuru(Guru guru, MultipartFile uploadPhoto, HttpServletRequest request){
        guruService.addGuru(guru,uploadPhoto,request);
    }


    @RequestMapping("/showByPage")
    public GuruDTO showByPage(Integer rows,Integer page){
        GuruDTO guruDTO = guruService.findByPage(page, rows);
        return guruDTO;
    }

    @RequestMapping("/remove")
    public void removeGuru(String[] ids){
        guruService.remove(ids);
    }
}
