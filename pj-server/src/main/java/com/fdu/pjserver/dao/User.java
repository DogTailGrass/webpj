package com.fdu.pjserver.dao;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Data
public class User {
    /**
     * 用户ID（学号）
     */
    @Id
    private String userId;

    /**
     * 姓名
     */
    private String userName;

    private String pwd;

    /**
     * 状态（0正常 1删除）
     */
    private Integer status;

    @CreatedDate
    private Date createTime;

    @CreatedBy
    private String createBy;

    @LastModifiedDate
    private Date updateTime;

    @LastModifiedBy
    private String updateBy;

}