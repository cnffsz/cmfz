package com.hx.cmfz.service;

import com.hx.cmfz.entity.Manager;

/**
 * Created by Administrator on 2018/7/4.
 */
public interface ManagerService {

    public Manager queryMgr(String name, String password);

}
