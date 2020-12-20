package com.fdu.pjserver.dao;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Student extends User {
    /**
     * 联系方式
     */
    private String mobile;

    private String school;

    /**
     * 类别
     */
    private String category;

    /**
     * 类型
     */
    private String type;

    /**
     * 辅导员姓名
     */
    private String teacherName;

    /**
     * 现居住地址
     */
    private String currentLocation;

    private String graduation;

    private String userRole;
}
