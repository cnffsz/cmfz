package com.hx.cmfz.service.impl;

import com.hx.cmfz.dao.LogDao;
import com.hx.cmfz.entity.Log;
import com.hx.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Transactional
    @Override
    public boolean logAdd(Log log) {
        int r = logDao.insertLog(log);
        if(r>0)
            return true;
        return false;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Map<String, Object> queryAllLog(Integer page, Integer pageSize) {
        List<Log> list = logDao.selectAllLog((page-1)*pageSize,pageSize);
        int count = logDao.count();
        Map<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }
}
