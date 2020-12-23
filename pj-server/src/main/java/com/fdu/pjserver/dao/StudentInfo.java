package com.fdu.pjserver.dao;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@DynamicUpdate
public class StudentInfo {
    /**
     * 用户ID（学号）
     */
    @Id
    private String userId;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 院系
     */
    private String department;

    /**
     * 分类（本科生，研究生，博士生）
     */
    private String degree;

    /**
     * 是否全日制
     */
    private Integer fullTime;

    /**
     * 辅导员姓名
     */
    private String counselorName;

    /**
     * 是否毕业班学生（0否 1是）
     */
    private Integer graduation;

    /**
     * 居住地址
     */
    private String address;

    @CreatedDate
    private Date createTime;

    @CreatedBy
    private String createBy;

    @LastModifiedDate
    private Date updateTime;

    @LastModifiedBy
    private String updateBy;
}
