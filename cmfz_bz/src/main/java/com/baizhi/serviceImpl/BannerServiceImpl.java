package com.baizhi.serviceImpl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.BannerDao;
import com.baizhi.dto.BannerDTO;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
 * Created by vincent on 2018/11/12.
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    //添加
    @Transactional
    @LogAnnotation(value = "上传轮播图")
    public void addBanner(Banner banner, MultipartFile uploadImg, HttpServletRequest request) {
        //指定包名
        String pack="banner";
        //调用工具类FileTool获取新的文件名--并上传文件
        String newFileName = FileTool.uploadFile(uploadImg, request,pack);
        banner.setImgPath("/"+pack+"/"+newFileName);
        banner.setId(CreateID.getId());
        banner.setUploadDate(new Date());
        //调用dao
        bannerDao.insert(banner);
    }

    //分页查询
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public BannerDTO findByPage(Integer currPage, Integer pageSize) {
        List<Banner> bannerList = bannerDao.selectByPage(currPage, pageSize);
        Integer total = bannerDao.selectTotal();
        //创建DTO对象并赋值
        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setRows(bannerList);
        bannerDTO.setTotal(total);
        return bannerDTO;
    }

    //修改状态
    @Transactional
    @LogAnnotation(value = "修改轮播图状态")
    public void modifyStatus(String status, String id) {
        bannerDao.updateStatus(status, id);
    }

    //删除/批量删除
    @Transactional
    @LogAnnotation(value = "删除轮播图")
    public void removeBanner(String[] ids) {
        bannerDao.delete(ids);
    }
}
