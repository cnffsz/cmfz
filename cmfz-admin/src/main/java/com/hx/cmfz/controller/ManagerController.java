package com.hx.cmfz.controller;

import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.service.ManagerService;
import com.hx.cmfz.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/7/4.
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public String login(String name,String password,String code,String checkbox,HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
        if(session.getAttribute("vcode").equals(code)){
            Manager m = managerService.queryMgr(name, password);
            if(m != null){
                if(checkbox != null){
                    name = URLEncoder.encode(name, "UTF-8");
                    Cookie c1 = new Cookie("name",name);
                    Cookie c2 = new Cookie("password",password);
                    c1.setMaxAge(60*60*24);
                    c2.setMaxAge(60*60*24);
                    c1.setPath("/");
                    c2.setPath("/");
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                session.setAttribute("manager",m);
                return "main";
            }
        }
        return "login";
    }

    @RequestMapping("/vcode")
    public void vcode(HttpSession session, HttpServletResponse response) throws Exception{
        ValidateCodeUtils vCode = new ValidateCodeUtils(100, 30, 4, 10);
        session.setAttribute("vcode", vCode.getCode());
        vCode.write(response.getOutputStream());
    }
}
