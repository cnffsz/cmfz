package com.hx.cmfz.test;

import com.hx.cmfz.dao.ManagerDao;
import com.hx.cmfz.service.ManagerService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/4.
 */
public class cmfzTest {

    @Test
    public void testService(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ManagerDao managerDao = (ManagerDao) applicationContext.getBean("managerDao");
        System.out.println(managerDao.selectMgr("hx"));
        ManagerService managerService = (ManagerService) applicationContext.getBean("managerServiceImpl");
        System.out.println(managerService.queryMgr("hx","123123")+" service");
    }
    
    @Test
    public void testMD5(){
        Md5Hash md5Hash = new Md5Hash("123123","gC2FGG",1024);
        System.out.println(md5Hash);
    }
}
