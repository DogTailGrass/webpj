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
@Table(name = "notice")
@DynamicUpdate
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公告显示时间
     */
    private Date validDate;

    /**
     * 公告显示时间戳
     */
    private Long validTime;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 公告状态
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
