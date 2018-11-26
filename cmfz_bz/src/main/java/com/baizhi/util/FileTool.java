package com.baizhi.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by vincent on 2018/11/12.
 */
public class FileTool {
    /*1.指定上传位置
      2.防止文件重名
      3.上传文件到指定文件夹
    */
    public static String uploadFile(MultipartFile multipartFile, HttpServletRequest request,String pack){

        String realPath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realPath+pack;
        File file = new File(uploadFilePath);
        if(!file.exists()){
            file.mkdir();
        }
        String originalFilename = multipartFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = uuid+"."+extension;

        //上传
        try {
            multipartFile.transferTo(new File(uploadFilePath,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newName;
    }
}
