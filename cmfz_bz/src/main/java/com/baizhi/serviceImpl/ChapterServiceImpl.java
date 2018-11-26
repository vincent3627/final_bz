package com.baizhi.serviceImpl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.AudioUtil;
import com.baizhi.util.CreateID;
import com.baizhi.util.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by vincent on 2018/11/14.
 */
@Service
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private AlbumDao albumDao;

    @Transactional
    @LogAnnotation(value = "上传")
    public void addChapter(Chapter chapter,
                           MultipartFile uploadAudio,
                           HttpServletRequest request) {

        try {
            String pack ="audio";
            //调用工具类上传文件 返回值为新的文件名
            String newFileName = FileTool.uploadFile(uploadAudio, request, pack);
            //拼接上传文件的获取路径
            String getPath=pack+"/"+newFileName;
            //创建一个新文件-准备参数
            File file = new File(request.getServletContext().getRealPath("/")+getPath);
            //调用工具类获取文件时长
            String duration = AudioUtil.getDuration(file);
            //获取文件大小
            long size = uploadAudio.getSize();
            double mb=size/1024.0/1024.0;
            //处理double类型数据,保留小数点后一位
            BigDecimal bigDecimal = new BigDecimal(mb);
            BigDecimal scale = bigDecimal.setScale(2, bigDecimal.ROUND_HALF_UP);
            String mbSize = scale + "MB";
            //将获取的数据存入chapter
            chapter.setSize(mbSize);
            chapter.setDuration(duration);
            chapter.setId(CreateID.getId());
            chapter.setCreateDate(new Date());
            chapter.setAudioPath(getPath);
            //调用dao-数据入库
            chapterDao.insert(chapter);
            //获取到对应专辑
            String id=chapter.getAlbumId();
            Album album = albumDao.selectById(id);
            //查询专辑里面的chapter数量
            Integer count = chapterDao.selectCountByPid(id);
            //调用专辑里的dao修改数量
            albumDao.updateCount(id,count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
