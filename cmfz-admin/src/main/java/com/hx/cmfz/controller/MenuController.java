package com.hx.cmfz.controller;

import com.hx.cmfz.entity.Menu;
import com.hx.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findMenu")
    @ResponseBody
    public List<Menu> findMenu(int parentId){

        List<Menu> menus = menuService.queryByParentId(parentId);

        return menus;

    }
}
