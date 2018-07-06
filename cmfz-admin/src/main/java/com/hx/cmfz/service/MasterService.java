package com.hx.cmfz.service;

import com.hx.cmfz.entity.Master;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/6.
 */
public interface MasterService {

    public Map<String,Object> queryByPage(Integer page,Integer pageSize);

    public Map<String,Object> queryByKey(String key,Integer page,Integer pageSize);

    public boolean addMaster(Master master);

    public boolean modifyMaster(Master master);

}
