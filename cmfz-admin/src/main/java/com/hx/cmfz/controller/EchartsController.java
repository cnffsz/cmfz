package com.hx.cmfz.controller;

import com.hx.cmfz.entity.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class EchartsController {

    @RequestMapping("/activeUser")
    @ResponseBody
    public Map<String, Object> getEchartsPic(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intervals",new String[]{"1天","3天","7天","10天","15天"});
        map.put("counts",new int[]{5,10,18,15,3});
        return map;
    }

    @RequestMapping("/distributeMan")
    @ResponseBody
    public List<City> getEcharts(){
        List<City> list= new ArrayList<City>();
        list.add(new City("北京","100"));
        list.add(new City("上海","200"));
        list.add(new City("河北","300"));
        list.add(new City("云南","200"));
        list.add(new City("黑龙江","700"));
        list.add(new City("安徽","500"));
        list.add(new City("新疆","900"));
        list.add(new City("浙江","1000"));
        list.add(new City("湖北","150"));
        list.add(new City("甘肃","190"));
        list.add(new City("内蒙古","300"));
        list.add(new City("吉林","600"));
        list.add(new City("贵州","200"));
        list.add(new City("青海","700"));
        list.add(new City("四川","300"));
        list.add(new City("海南","500"));
        list.add(new City("香港","800"));
        list.add(new City("澳门","100"));
        list.add(new City("台湾","550"));
        list.add(new City("宁夏","770"));
        list.add(new City("天津","100"));
        list.add(new City("重庆","430"));
        list.add(new City("河南","2000"));
        list.add(new City("辽宁","3000"));
        list.add(new City("湖南","1000"));
        list.add(new City("山东","2020"));
        list.add(new City("江苏","800"));
        list.add(new City("江西","102"));
        list.add(new City("广西","134"));
        list.add(new City("山西","256"));
        list.add(new City("陕西","654"));
        list.add(new City("福建","764"));
        list.add(new City("广东","234"));
        list.add(new City("西藏","543"));

        return list;
        /**/
    }

    @RequestMapping("/distributeWomen")
    @ResponseBody
    public List<City> distributeWomen(){
        List<City> list= new ArrayList<City>();
                                       ;
        list.add(new City("北京",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("上海",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("河北",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("云南",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("黑龙江",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("安徽",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("新疆",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("浙江",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("湖北",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("甘肃",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("内蒙古",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("吉林",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("贵州",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("青海",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("四川",String.valueOf((int)(Math.random()*1000))));
        list.add(new City("海南",String.valueOf((int)(Math.random()*1000))));
        return list;
    }




}
