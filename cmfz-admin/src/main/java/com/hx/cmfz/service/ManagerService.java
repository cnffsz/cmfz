package com.hx.cmfz.service;

import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.entity.SysPermission;
import com.hx.cmfz.entity.SysRole;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public interface ManagerService {

    public Manager queryMgr(String name);

    public List<SysRole> queryRoleByMgrName(String name);

    public List<SysPermission> queryPermisssionByMgrName(String name);

}
