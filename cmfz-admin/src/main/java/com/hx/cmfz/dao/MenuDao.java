package com.hx.cmfz.dao;

import com.hx.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface MenuDao {

    public List<Menu> selectByLevel(int level);
    public List<Menu> selectByParentId(int parentId);
}
