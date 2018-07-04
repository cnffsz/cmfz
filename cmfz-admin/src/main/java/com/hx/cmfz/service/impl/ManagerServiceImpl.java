package com.hx.cmfz.service.impl;

import com.hx.cmfz.dao.ManagerDao;
import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2018/7/4.
 */


@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Transactional(readOnly = true)
    @Override
    public Manager queryMgr(String name, String password) {

        Manager manager = managerDao.selectMgr(name);

        if(manager != null){
            if(manager.getMgrPwd().equals(password))
                return manager;
        }

        return null;

    }
}

