package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by vincent on 2018/11/14.
 */
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    /*
        上传
     */
    @RequestMapping("/uploadChapter")
    public void uploadChapter(Chapter chapter,
                              MultipartFile uploadAudio,
                              HttpServletRequest request){
        chapterService.addChapter(chapter, uploadAudio, request);
    }

    /*
         下载
     */
    @RequestMapping("/download")
    public void downloadChapter(String title,
                                String audioPath,
                                HttpServletRequest request,
                                HttpServletResponse response){

        String realPath = request.getServletContext().getRealPath("/");
        String filePath = realPath + audioPath;
        File file = new File(filePath);

        String extension = FilenameUtils.getExtension(audioPath);
        title = title + "." +extension;
        String a = null;
         try {
             a = new String(title.getBytes("utf-8"), "ISO-8859-1");

         }catch (UnsupportedEncodingException e){
             e.printStackTrace();
         }

         response.setContentType("audio/mpeg");
         response.setHeader("Content-Disposition","attachment;filename="+a);
         try{
             ServletOutputStream outputStream = response.getOutputStream();
             outputStream.write(FileUtils.readFileToByteArray(file));
             outputStream.flush();
         }catch(IOException e){
             e.printStackTrace();
         }
    }
}
