package com.baizhi.controller;

import com.baizhi.dto.BannerDTO;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vincent on 2018/11/12.
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/uploadBanner")
    public void uploadBanner(Banner banner, MultipartFile uploadImg,HttpServletRequest request ){
        bannerService.addBanner(banner, uploadImg, request);
    }

    @RequestMapping("/showByPage")
    public BannerDTO showByPage(Integer rows,Integer page){
        BannerDTO bannerDTO = bannerService.findByPage(page, rows);
        return bannerDTO;
    }

    @RequestMapping("/removeBanner")
    public void removeBanner(String[] ids){
        bannerService.removeBanner(ids);
    }

    @RequestMapping("/editBanner")
    public void editBanner(String id,String status){
        bannerService.modifyStatus(status,id);
    }
}
