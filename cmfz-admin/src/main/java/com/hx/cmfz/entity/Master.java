package com.hx.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/6.
 */
public class Master implements Serializable{

    @Excel(name = "上师编号")
    private String masterId;
    @Excel(name = "上师法号")
    private String masterName;
    @Excel(name = "上师照片")
    private String masterPhoto;
    @Excel(name = "上师简介")
    private String masterSummary;

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterSummary() {
        return masterSummary;
    }

    public void setMasterSummary(String masterSummary) {
        this.masterSummary = masterSummary;
    }

    public Master() {
    }

    public Master(String masterId, String masterName, String masterPhoto, String masterSummary) {
        this.masterId = masterId;
        this.masterName = masterName;
        this.masterPhoto = masterPhoto;
        this.masterSummary = masterSummary;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterSummary='" + masterSummary + '\'' +
                '}';
    }
}
