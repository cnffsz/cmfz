package com.hx.cmfz.dao;

import com.hx.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface LogDao {

    public int insertLog(Log log);

    public List<Log> selectAllLog(@Param("index")Integer index, @Param("pageSize")Integer pageSize);

    public int count();
}
