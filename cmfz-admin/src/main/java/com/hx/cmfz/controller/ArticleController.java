package com.hx.cmfz.controller;

import com.hx.cmfz.entity.Article;
import com.hx.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/9.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/showArticle")
    @ResponseBody
    public Map<String,Object> getArticle(@RequestParam("rows")int totalSize, @RequestParam("page")int pageIndex){
        Map<String, Object> map = articleService.queryArticle(totalSize, pageIndex);
        return map;
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    public String addArticle(Article article){
        System.out.println(article);
        if(article.getArticleStatus()==null){
            article.setArticleStatus("off");
        }
        String name1= UUID.randomUUID().toString().replace("-","");
        article.setArticleId(name1);
        article.setMasterId(1);
        article.setArticleDate(new Date());
        boolean a=articleService.addArticle(article);
        if(a){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Article uploadFiles(@RequestParam("files") MultipartFile[] files, HttpSession session){
        Article article = new Article();
        ArrayList<String> data =new ArrayList<String>();
        try {
            String realPath=session.getServletContext().getRealPath("/").replace("cmfz-admin","upload\\articlePic");
            if(files!=null && files.length!=0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    file.transferTo(new File(realPath+fileName));
                    data.add("/cmfz-admin/upload/articlePic/"+fileName);
                }
                article.setErrno(0);
                article.setData(data);
            }
        } catch (IOException e) {
            article.setErrno(1);
            e.printStackTrace();
        }
        return article;

    }

}
