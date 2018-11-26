package com.baizhi.service;

import com.baizhi.dto.AlbumDTO;
import com.baizhi.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vincent on 2018/11/14.
 */
public interface AlbumService {
    //添加
    void addAlbum(Album album, MultipartFile corverImg, HttpServletRequest request);

    //分页查询
    AlbumDTO findByPage(Integer currPage, Integer pageSize);

    //根据id查询
    Album findById(String id);

}
