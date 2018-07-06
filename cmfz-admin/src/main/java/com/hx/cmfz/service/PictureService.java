package com.hx.cmfz.service;

import com.hx.cmfz.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface PictureService {

    public Map<String,Object> queryPicByPage(Integer page,Integer pageSize);

    public boolean addPic(Picture picture);

    public boolean modifyPic(Picture picture);
}
