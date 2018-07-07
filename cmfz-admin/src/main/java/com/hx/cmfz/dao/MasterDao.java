package com.hx.cmfz.dao;

import com.hx.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
public interface MasterDao {

    public int insertMaster(Master master);

    public int updateMaster(Master master);

    public List<Master> selectByPage(@Param("index")Integer index,@Param("pageSize")Integer pageSize);

    public List<Master> selectByKey(@Param("key")String key ,@Param("index")Integer index ,@Param("pageSize")Integer pageSize);

    public int count();

    public int countByKey(String key);

}
