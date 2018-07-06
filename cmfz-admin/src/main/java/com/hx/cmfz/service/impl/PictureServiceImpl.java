package com.hx.cmfz.service.impl;

import com.hx.cmfz.dao.PictureDao;
import com.hx.cmfz.entity.Picture;
import com.hx.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/5.
 */

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Map<String, Object> queryPicByPage(Integer page, Integer pageSize) {

        List<Picture> list = pictureDao.selectPicByPage((page-1)*pageSize,pageSize);
        int count = pictureDao.count();
        Map<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public boolean addPic(Picture picture) {
        int r = pictureDao.insertPic(picture);
        if(r>0)
            return  true;
        return false;
    }

    @Override
    public boolean modifyPic(Picture picture) {
        int r = pictureDao.updatePic(picture);
        if(r>0)
            return  true;
        return false;
    }
}
