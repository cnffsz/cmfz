package com.hx.cmfz.service.impl;

import com.hx.cmfz.dao.ManagerDao;
import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.entity.SysPermission;
import com.hx.cmfz.entity.SysRole;
import com.hx.cmfz.service.ManagerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Administrator on 2018/7/4.
 */


@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public Manager queryMgr(String name) {

        return managerDao.selectMgr(name);

        /*if(manager != null){
            String newPwd = DigestUtils.md5Hex(password+manager.getSalt());
            if(manager.getMgrPwd().equals(newPwd))
                return manager;
        }

        return null;*/

    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public List<SysRole> queryRoleByMgrName(String name) {
        return managerDao.selectRoleByMgrName(name);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public List<SysPermission> queryPermisssionByMgrName(String name) {
        return managerDao.selectPermisssionByMgrName(name);
    }
}

