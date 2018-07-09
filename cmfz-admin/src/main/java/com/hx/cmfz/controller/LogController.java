package com.hx.cmfz.controller;

import com.hx.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/9.
 */
@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/findLog")
    @ResponseBody
    public Map<String,Object> findStudents(@RequestParam("page")Integer page, @RequestParam("rows")Integer pageSize){

        return logService.queryAllLog(page, pageSize);

    }

}
