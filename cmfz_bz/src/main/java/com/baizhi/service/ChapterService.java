package com.baizhi.service;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vincent on 2018/11/14.
 */
public interface ChapterService {
    //添加
    void addChapter(Chapter chapter,
                    MultipartFile uploadAudio,
                    HttpServletRequest request);
}
