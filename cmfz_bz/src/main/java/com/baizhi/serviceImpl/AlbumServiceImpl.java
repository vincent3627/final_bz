package com.baizhi.serviceImpl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.AlbumDao;
import com.baizhi.dto.AlbumDTO;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.util.CreateID;
import com.baizhi.util.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2018/11/14.
 */
@Service
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumDao albumDao;

    /*
       上传文件

     */
    @Transactional
    @LogAnnotation(value = "上传专辑")
    public void addAlbum(Album album, MultipartFile uploadCorverImg, HttpServletRequest request) {

        String pack="albumImg";
        //调用工具类
        String newFileName = FileTool.uploadFile(uploadCorverImg, request, pack);

        album.setId(CreateID.getId());
        album.setCorverImg("/"+pack+"/"+newFileName);
        album.setCreateDate(new Date());
        //调用dao-数据入库
        albumDao.insert(album);
    }

    /*
        分页查询
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public AlbumDTO findByPage(Integer currPage, Integer pageSize) {
        List<Album> albumList = albumDao.selectByPage(currPage, pageSize);
        Integer total = albumDao.selectTotal();

        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setRows(albumList);
        albumDTO.setTotal(total);
        return albumDTO;
    }
    /*
        根据id查询
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Album findById(String id) {
        Album album = albumDao.selectById(id);
        return album;
    }
}
