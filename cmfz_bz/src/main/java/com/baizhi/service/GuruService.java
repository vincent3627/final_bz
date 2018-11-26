package com.baizhi.service;

import com.baizhi.dto.GuruDTO;
import com.baizhi.entity.Guru;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vincent on 2018/11/20.
 */
public interface GuruService {

    //上传
    void addGuru(Guru guru, MultipartFile uploadPhoto, HttpServletRequest request);

    //分页查询
    GuruDTO findByPage(Integer currPage, Integer pageSize);

    //删除
    void remove(String[] ids);

}
