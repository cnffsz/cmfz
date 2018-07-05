package com.hx.cmfz.service.impl;

import com.hx.cmfz.dao.MenuDao;
import com.hx.cmfz.entity.Menu;
import com.hx.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public List<Menu> queryByParentId(int parentId) {

        List<Menu> menus = menuDao.selectByParentId(parentId);

        return menus;

    }
}
