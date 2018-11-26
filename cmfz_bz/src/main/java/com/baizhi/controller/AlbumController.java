package com.baizhi.controller;

import com.baizhi.dto.AlbumDTO;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vincent on 2018/11/14.
 */
@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    /*
        上传
     */
    @RequestMapping("/uploadAlbum")
    public void uploadAlbum(Album album, MultipartFile uploadCorverImg, HttpServletRequest request){
        albumService.addAlbum(album, uploadCorverImg, request);
    }

    /*
        分页展示
     */
    @RequestMapping("/showByPage")
    public AlbumDTO showByPage(Integer rows,Integer page){
        AlbumDTO albumDTO = albumService.findByPage(page, rows);
        return albumDTO;
    }

    /*
        根据id获取
     */
    @RequestMapping("/showOne")
    public Album showOne(String id){
        Album album = albumService.findById(id);
        return album;
    }
}
