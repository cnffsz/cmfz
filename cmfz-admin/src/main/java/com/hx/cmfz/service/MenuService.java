package com.hx.cmfz.service;

import com.hx.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface MenuService {

    public List<Menu> queryByParentId(int parentId);

}
