package com.hx.cmfz.controller;

import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.service.ManagerService;
import com.hx.cmfz.utils.ValidateCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    public String login(String name,String password,String code,String checkbox,boolean rememberMe,HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
        if(session.getAttribute("vcode").equals(code)){
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(name,password,rememberMe));
                if(checkbox != null){
                    name = URLEncoder.encode(name, "UTF-8");
                    Cookie c1 = new Cookie("name",name);
                    c1.setMaxAge(60*60*24);
                    c1.setPath("/");
                    response.addCookie(c1);
                }else{
                    Cookie c1 = new Cookie("name",null);
                    c1.setMaxAge(60*60*24);
                    c1.setPath("/");
                    response.addCookie(c1);
                }
                session.setAttribute("managerName",name);
                return "main/main";
            } catch (AuthenticationException e) {
                System.out.println("认证失败");
                e.printStackTrace();
            }
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() throws UnsupportedEncodingException {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    @RequestMapping("/vcode")
    public void vcode(HttpSession session, HttpServletResponse response) throws Exception{
        ValidateCodeUtils vCode = new ValidateCodeUtils(100, 30, 1, 10);
        session.setAttribute("vcode", vCode.getCode());
        vCode.write(response.getOutputStream());
    }
}
