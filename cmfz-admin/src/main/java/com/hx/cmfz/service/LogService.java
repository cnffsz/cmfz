package com.hx.cmfz.service;

import com.hx.cmfz.entity.Log;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
public interface LogService {

    public boolean logAdd(Log log);

    public Map<String , Object> queryAllLog(Integer page, Integer pageSize);
}
