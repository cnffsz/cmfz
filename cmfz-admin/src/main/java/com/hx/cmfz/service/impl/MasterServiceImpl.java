package com.hx.cmfz.service.impl;

import com.hx.cmfz.dao.MasterDao;
import com.hx.cmfz.entity.Master;
import com.hx.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/6.
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService{

    @Autowired
    private MasterDao masterDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Map<String, Object> queryByPage(Integer page, Integer pageSize) {
        List<Master> list = masterDao.selectByPage((page-1)*pageSize,pageSize);
        int count = masterDao.count();
        Map<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Map<String, Object> queryByKey(String key, Integer page, Integer pageSize) {
        List<Master> list = masterDao.selectByKey("%"+key+"%",(page-1)*pageSize,pageSize);
        int count = masterDao.countByKey(key);
        Map<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Master> queryAll() {
        return masterDao.selectAll();
    }

    @Transactional
    @Override
    public boolean addMaster(Master master) {

        int r = masterDao.insertMaster(master);
        if(r>0)
            return true;
        return false;
    }

    @Override
    public boolean addExcel(List<Master> masters) {

        int r = masterDao.insertExcel(masters);
        if(r>0)
            return true;
        return false;

    }

    @Transactional
    @Override
    public boolean modifyMaster(Master master) {

        int r = masterDao.updateMaster(master);
        if(r>0)
            return true;
        return false;

    }
}
