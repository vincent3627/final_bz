package com.baizhi.serviceImpl;

import com.baizhi.aop.LogAnnotation;
import com.baizhi.dao.GuruDao;
import com.baizhi.dto.GuruDTO;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import com.baizhi.util.CreateID;
import com.baizhi.util.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by vincent on 2018/11/20.
 */
@Service
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;

    @Transactional
    @LogAnnotation(value = "添加上师")
    public void addGuru(Guru guru, MultipartFile uploadPhoto, HttpServletRequest request) {
        String pack="guruPhoto";
        //调用工具类上传上师头像照片
        String newFileName = FileTool.uploadFile(uploadPhoto, request, pack);
        guru.setId(CreateID.getId());
        guru.setPhotoImg("/"+pack+"/"+newFileName);
        guruDao.insert(guru);

    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public GuruDTO findByPage(Integer currPage, Integer pageSize) {
        List<Guru> guruList = guruDao.selectByPage(currPage, pageSize);
        Integer total = guruDao.selectTotal();
        GuruDTO guruDTO = new GuruDTO();
        guruDTO.setRows(guruList);
        guruDTO.setTotal(total);
        return guruDTO;
    }

    @Transactional
    @LogAnnotation(value = "上传上师")
    public void remove(String[] ids) {
        guruDao.delete(ids);
    }
}
