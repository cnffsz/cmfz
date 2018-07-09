package com.hx.cmfz.utils;

import com.hx.cmfz.entity.Log;
import com.hx.cmfz.entity.Manager;
import com.hx.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/9.
 */
@Aspect
@Component
public class LogAdvice {

    @Pointcut("execution(* com.hx.cmfz.service.impl.*.modify*(..))||execution(* com.hx.cmfz.service.impl.*.add*(..))||execution(* com.hx.cmfz.service.impl.*.remove*(..))")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        Object obj = pjp.proceed();

        String logId = UUID.randomUUID().toString().replace("-", "");

        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session =request.getSession();

        String username = ((Manager)session.getAttribute("manager")).getMgrName();

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        String resource = pjp.getTarget().getClass().getSimpleName().replace("ServiceImpl", "");
        System.out.println(resource);

        Method method = methodSignature.getMethod();

        String action = method.getName();

        StringBuilder message = new StringBuilder();

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            message.append(arg+";");
        }

        String result = null;
        if((boolean)obj)
            result = "success";
        else
            result = "fail";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        LogService logService = (LogService) applicationContext.getBean("logServiceImpl");

        Log log = new Log(logId, username, new Date(), resource, action, message.toString(), result);
        System.out.println(log);

        logService.logAdd(log);

        return obj;

    }

}
