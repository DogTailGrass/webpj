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
@Data
@DynamicUpdate
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date validDate;

    private Long validTime;

    private String title;

    private String content;

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
