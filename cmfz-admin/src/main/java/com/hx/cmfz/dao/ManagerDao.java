package com.hx.cmfz.dao;

import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.entity.SysPermission;
import com.hx.cmfz.entity.SysRole;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public interface ManagerDao {

    public Manager selectMgr(String name);

    public List<SysRole> selectRoleByMgrName(String name);

    public List<SysPermission> selectPermisssionByMgrName(String name);

}
