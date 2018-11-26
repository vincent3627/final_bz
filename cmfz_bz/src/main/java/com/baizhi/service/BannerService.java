package com.baizhi.service;

import com.baizhi.dto.BannerDTO;
import com.baizhi.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vincent on 2018/11/12.
 */
public interface BannerService {
    //添加
    void addBanner(Banner banner, MultipartFile uploadImg, HttpServletRequest request);

    //分页查询
    BannerDTO findByPage(Integer currPage, Integer pageSize);

    //修改装态
    void modifyStatus(String status, String id);

    //删除/批量删除
    void removeBanner(String[] ids);
}
