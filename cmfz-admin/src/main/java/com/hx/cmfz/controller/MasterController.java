package com.hx.cmfz.controller;

import com.hx.cmfz.entity.Master;
import com.hx.cmfz.service.MasterService;
import com.hx.cmfz.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/6.
 */
@Controller
public class MasterController {

    @Autowired
    private MasterService masterService;

    @RequestMapping("/findMaster")
    @ResponseBody
    public Map<String,Object> findStudents(@RequestParam("page")Integer page, @RequestParam("rows")Integer pageSize){

        return masterService.queryByPage(page,pageSize);

    }

    @RequestMapping("/findByKey")
    @ResponseBody
    public Map<String,Object> findStudents(@RequestParam("key")String key,@RequestParam("page")Integer page, @RequestParam("rows")Integer pageSize){

        return masterService.queryByKey(key,page,pageSize);

    }

    @RequestMapping("/addMaster")
    @ResponseBody
    public String addPicture(String masterName, String masterSummary, MultipartFile masterPhoto, HttpSession session) throws IOException {

        String masterId = UUID.randomUUID().toString().replace("-", "");

        String masterPhotoName = masterPhoto.getOriginalFilename();

        String realPath=session.getServletContext().getRealPath("/").replace("cmfz-admin","masterPhoto");

        File file = new File(realPath, masterPhotoName);

        if(!file.exists()){
            file.mkdirs();
        }

        masterPhoto.transferTo(file);

        Master master = new Master(masterId, masterName,masterPhotoName,masterSummary);

        boolean flag = masterService.addMaster(master);

        if(flag)
            return "success";

        return "error";
    }

    @RequestMapping("/modifyMaster")
    @ResponseBody
    public String modifyMaster(String masterId, String masterName, String masterSummary, String masterPhoto){

        Master master = new Master(masterId, masterName,masterPhoto,masterSummary);

        boolean flag = masterService.modifyMaster(master);

        if(flag)
            return "success";

        return "error";
    }

    @RequestMapping("/importExcel")
    @ResponseBody
    public String importExcel(MultipartFile excel){

        List<Master> masterList = FileUtil.importExcel(excel,0,1,Master.class);

        for (Master master : masterList) {
            String masterId = UUID.randomUUID().toString().replace("-", "");
            master.setMasterId(masterId);
            boolean flag = masterService.addMaster(master);
            if(!flag)
                return "error";
        }

        return "success";

    }


}
