package com.hx.cmfz.dao;

import com.hx.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface PictureDao {

    public int insertPic(Picture picture);

    public int updatePic(Picture picture);

    public List<Picture> selectPicByPage(@Param("index")Integer index,@Param("pageSize")Integer pageSize);

    public int count();
}
