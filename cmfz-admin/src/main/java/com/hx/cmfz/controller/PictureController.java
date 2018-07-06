package com.hx.cmfz.controller;

import com.hx.cmfz.entity.Picture;
import com.hx.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/5.
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/findPicture")
    @ResponseBody
    public Map<String,Object> findStudents(@RequestParam("page")Integer page, @RequestParam("rows")Integer pageSize){

        return pictureService.queryPicByPage(page,pageSize);

    }

    @RequestMapping("/addPicture")
    @ResponseBody
    public String addPicture(String pictureDescription, Integer pictureStatus, MultipartFile picturePath, HttpSession session) throws IOException {

        String pictureId = UUID.randomUUID().toString().replace("-", "");

        String picName = picturePath.getOriginalFilename();

        String realPath=session.getServletContext().getRealPath("/").replace("cmfz-admin","upload");

        session.setAttribute("realPath", URLEncoder.encode(realPath,"utf-8"));

        File file = new File(realPath, picName);

        if(!file.exists()){
            file.mkdirs();
        }

        picturePath.transferTo(file);

        Picture picture = new Picture(pictureId, picName,new Date(), pictureDescription, pictureStatus);

        boolean flag = pictureService.addPic(picture);

        if(flag)
            return "success";

        return "error";
    }

    @RequestMapping("/modifyPicture")
    @ResponseBody
    public String modifyPicture(String pictureId,String picturePath,String pictureDescription,Integer pictureStatus,String pictureDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Picture picture = new Picture(pictureId, picturePath, sdf.parse(pictureDate), pictureDescription, pictureStatus);

        boolean flag = pictureService.modifyPic(picture);

        if(flag)
            return "success";

        return "error";
    }
}
