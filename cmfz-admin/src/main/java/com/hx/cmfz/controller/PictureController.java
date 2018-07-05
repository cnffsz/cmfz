package com.hx.cmfz.controller;

import com.hx.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/5.
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/findPicture")
    @ResponseBody
    public Map<String,Object> findStudents(@RequestParam("page")Integer page, @RequestParam("rows")Integer pageSize) throws Exception{
        return pictureService.queryPicByPage(page,pageSize);
    }
}
